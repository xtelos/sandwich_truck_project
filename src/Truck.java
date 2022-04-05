import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.LongSummaryStatistics;

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
            image = ImageIO.read(new File("images/FoodTruckIcon.jpeg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * returns true if destinations is not empty
     * @return
     */
    public boolean hasDestinations(){
        return !destinations.isEmpty();
    }

    /**
     * Makes truck Move. if truck arrives, it stops. If not, update is called until it has arrived
     */
    @Override
    public void update() {
        if (!destinations.isEmpty()) {
            Location currentDestination = destinations.getFirst();
            Location closestIntersection = currentDestination.getClosestIntersection();

            boolean canMoveUpOrDown = location.getX() % 100 == 0;
            boolean canMoveLeftOrRight = location.getY() % 100 == 0;

            move(currentDestination, closestIntersection, canMoveUpOrDown, canMoveLeftOrRight);
        }
    }

    /**
     * \logic for moving the truck
     * @param destination
     * @param intersection
     * @param upDown
     * @param leftRight
     */
    private void move(Location destination, Location intersection, boolean upDown, boolean leftRight)
    {
        if(location.equals(destination)) {
            destinations.removeFirst();
            this.update();
        }

        else {
            //If x or Y is on a side street clause, focus on trying to get to the opposite value

            if (destination.getY() > location.getY() && upDown)
                truckMoveDown();

            else if(destination.getY() > location.getY() && !upDown)
            {
                if (destination.getClosestIntersectionX() > location.getX())
                    truckMoveRight();
                else
                    truckMoveLeft();

                destinations.addFirst(intersection);

            }


            else if (destination.getY() < location.getY() && upDown)
                truckMoveUp();

            else if(destination.getY() < location.getY() && !upDown)
            {
                if (destination.getClosestIntersectionX() > location.getX())
                    truckMoveRight();
                else
                    truckMoveLeft();

                destinations.addFirst(intersection);

            }


            else if (destination.getX() > location.getX() && leftRight)
                truckMoveRight();

            else if(destination.getX() > location.getX() && !leftRight)
            {
                if (destination.getClosestIntersectionY() > location.getY())
                    truckMoveDown();
                else
                    truckMoveUp();

                destinations.addFirst(intersection);

            }


            else if (destination.getX() < location.getX() && leftRight)
                truckMoveLeft();

            else if(destination.getX() < location.getX() && !leftRight)
            {
                if (destination.getClosestIntersectionY() > location.getY())
                    truckMoveDown();
                else
                    truckMoveUp();

                destinations.addFirst(intersection);
            }
        }
    }


    /**
     * moves truck up
     */
    private void truckMoveUp(){
        location.setLocation(location.getX(), location.getY()-1);
    }

    /**
     * moves truck down
     */
    private void truckMoveDown(){
        location.setLocation(location.getX(), location.getY()+1);
    }

    /**
     * moves truck left
     */
    private void truckMoveLeft(){
        location.setLocation(location.getX()-1, location.getY());
    }

    /**
     * moves truck right
     */
    private void truckMoveRight(){
        location.setLocation(location.getX()+1, location.getY());
    }

    /**
     * truck moves but can only make right turns
     */
    public void moveRight(){

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

