import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Truck extends JPanel implements Representations {

    public Location location;
    public LinkedList<Location> destinations;
    public LinkedList<String> sandwichOrders;
    public BufferedImage image;
    public RouteStrategy strategy;
    public TruckMovement truckMovement;
    /**
     * creates a truck with a specific location and a linkedlist of destinations to drive to
     */
    Truck(RouteStrategy strategy) {
        this.strategy = strategy;
        this.location = new Location(500,500);
        destinations = new LinkedList<>();
        sandwichOrders = new LinkedList<>();
        DestinationCreator destinationCreator = new DestinationCreator();
        destinationCreator.createDestinations(destinations, this.strategy);
        sandwichOrders = destinationCreator.getSandwichOrders();
        destinations.addLast(new Location(500,500));

        truckMovement = new TruckMovement(this,destinations);

        createImage();
    }

    /**
     * Getter for the x value
     * @return x value of location
     */
    @Override
    public int getLocationX() {
        return location.getX();
    }

    /**
     * Getter for the y value
     * @return y value of location
     */
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

            boolean canMoveUpOrDown = location.getX() % 100 == 0;
            boolean canMoveLeftOrRight = location.getY() % 100 == 0;

            truckMovement.move(currentDestination, canMoveUpOrDown, canMoveLeftOrRight);
        }
    }

    /**
     * converts a street into a letter for GUI display
     * @param street
     * @return
     */
    public String letterLocation(int street)
    {
        return location.streetToLetter(street);
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

    /**
     * Returns the distance travelled from TruckMovement
     * @return distance traveled
     */
    public double getDistanceTravelled()
    {
        return truckMovement.getDistanceTravelled();
    }


    /**
     * gets the next sandwich on the list ready
     */
    public void updateSandwiches(){
        sandwichOrders.removeFirst();
    }

    public String currentSandwich(){
        return sandwichOrders.getFirst();
    }
}
