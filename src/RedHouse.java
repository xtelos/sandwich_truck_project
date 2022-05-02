import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class RedHouse extends JPanel implements Representations {

    public Location location;
    public LinkedList<Location> destinations;
    public BufferedImage image;

    /**
     * Takes the route strategy and creates the destinations for where houses should be placed
     * @param strategy
     */
    RedHouse(RouteStrategy strategy){
        this.destinations = new LinkedList<>();

        DestinationCreator destinationCreator = new DestinationCreator();
        destinationCreator.createDestinations(destinations, strategy);
        this.location = this.destinations.getFirst();
        createImage();
    }

    /**
     * returns location x value
     * @return location
     */
    @Override
    public int getLocationX() {
        return location.getX();
    }

    /**
     * returns location y value
     * @return location
     */
    @Override
    public int getLocationY() {
        return location.getY();
    }

    /**
     * creates an image for the house
     */
    @Override
    public void createImage() {
        try {
            image = ImageIO.read(new File("images/HouseType2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates the house location if the truck arrives
     */
    @Override
    public void update() {
        if (destinations.size()>1)
        {
            destinations.removeFirst();
            location = destinations.getFirst();
        }
        else if(!destinations.isEmpty()){
            destinations.removeFirst();
            image = null;
        }
    }

    /**
     * Determines if destination list is empty and returns a boolean
     * @return true if destination list is empty
     */
    public boolean isEmpty(){
        return destinations.isEmpty();
    }

    /**
     * paints the house
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,location.getX(),location.getY(),20,20,null);
    }

    /**
     * converts street address to letter for GUI display
     * @param street
     * @return location
     */
    public String letterLocation(int street)
    {
        return location.streetToLetter(street);
    }
}