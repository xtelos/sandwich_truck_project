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
        Location currentDestination = destinations.getFirst();
        Location closestIntersectionDestination = currentDestination.getClosestIntersection();
        Location closestIntersectionCurrent = location.getClosestIntersection();

        boolean canMoveUpOrDown = location.getX() % 100 == 0;
        boolean canMoveLeftOrRight = location.getY() % 100 == 0;

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

            if (currentDestination.getY() > location.getY() && canMoveUpOrDown)
                truckMoveDown();

            else if(currentDestination.getY() > location.getY() && !canMoveUpOrDown)
            {
                if (location.getClosestIntersectionX() > location.getX())
                    truckMoveRight();
                else
                    truckMoveLeft();

                destinations.addFirst(closestIntersectionDestination);

            }


            else if (currentDestination.getY() < location.getY() && canMoveUpOrDown)
                truckMoveUp();

            else if(currentDestination.getY() < location.getY() && !canMoveUpOrDown)
            {
                if (location.getClosestIntersectionX() > location.getX())
                    truckMoveRight();
                else
                    truckMoveLeft();

                destinations.addFirst(closestIntersectionDestination);

            }


            else if (currentDestination.getX() > location.getX() && canMoveLeftOrRight)
                truckMoveRight();

            else if(currentDestination.getX() > location.getX() && !canMoveLeftOrRight)
            {
                if (location.getClosestIntersectionY() > location.getY())
                    truckMoveDown();
                else
                    truckMoveUp();

                destinations.addFirst(closestIntersectionDestination);

            }


            else if (currentDestination.getX() < location.getX() && canMoveLeftOrRight)
                truckMoveLeft();

            else if(currentDestination.getX() < location.getX() && !canMoveLeftOrRight)
            {
                if (location.getClosestIntersectionY() > location.getY())
                    truckMoveDown();
                else
                    truckMoveUp();

                destinations.addFirst(closestIntersectionDestination);

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
    public void updateRightOnly(){

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

