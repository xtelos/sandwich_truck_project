import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Truck extends JPanel implements Representations {

    public Location location;
    public LinkedList<Location> destinations;
    public BufferedImage image;
    public RouteStrategy strategy;

    /**
     * creates a truck with a specific location and a linkedlist of destinations to drive to
     * @param location
     * @param destinations
     */
    Truck(Location location, LinkedList<Location> destinations, RouteStrategy strategy) {
        this.location = location;
        this.destinations = destinations;
        this.strategy = strategy;
        createImage();
    }

    @Override
    public int getLocationX() {
        return location.getX();
    }

    @Override
    public int getLocationY() {
        return location.getY();
    }


    /**
     * Creates the image of the foodtruck
     */
    @Override
    public void createImage() {
        try {
            image = ImageIO.read(new File("src/FoodTruckIcon.jpeg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean hasDestinations(){
        return !destinations.isEmpty();
    }

    /**
     * Makes truck Move. if truck arrives, it stops. If not, update is called until it has arrived
     */
    @Override
    public void update() {
        Location currentDestination = destinations.getFirst();

        int locationDifferenceX = currentDestination.getX() % 100;
        int locationDifferenceY = currentDestination.getY() % 100;

        if(location.equals(currentDestination)) {
            destinations.removeFirst();
            this.update();
        }
        else {
//            if(location.getY() == currentDestination.getY())
//                location = new Location(location.getX()+20, location.getY());
//            else
//                location = new Location(location.getX(), location.getY()+20);
//            test code that to make the truck move along the road

            if (currentDestination.getY() > location.getY())
            {
                if (location.getX() % 100 == 0 && location.getY() % 100 == 0)
                    location.setDestination(location.getX(), location.getY()+1);
                else
                {
                    location.setDestination(location.getX(), location.getY()+1);
                    destinations.addFirst(currentDestination);
                }

            }

            else if (currentDestination.getY() < location.getY())
            {
                if (location.getX() % 100 == 0  && location.getY() % 100 == 0)
                    location.setDestination(location.getX(), location.getY()-1);
                else
                {
                    location.setDestination(location.getX(), location.getY()-1);
                    destinations.addFirst(currentDestination);
                }

            }

            else if (currentDestination.getX() > location.getX())
            {
                if (location.getX() % 100 == 0  && location.getY() % 100 == 0)
                    location.setDestination(location.getX()+1, location.getY());
                else
                {
                    location.setDestination(location.getX()+1, location.getY());
                    destinations.addFirst(currentDestination);
                }

            }
            else if (currentDestination.getX() < location.getX())
            {
                if (location.getX() % 100 == 0 && location.getY() % 100 == 0)
                    location.setDestination(location.getX()-1, location.getY());
                else
                {
                    location.setDestination(location.getX()-1, location.getY());
                    destinations.addFirst(currentDestination);
                }
            }
        }
    }

    /**
     * paints the truck onto the grid
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,location.getX()-10,location.getY()-10,20,20,null);
    }
}

