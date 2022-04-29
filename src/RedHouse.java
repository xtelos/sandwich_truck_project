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

    RedHouse(RouteStrategy strategy){
        this.destinations = new LinkedList<>();

        DestinationCreator destinationCreator = new DestinationCreator();
        destinationCreator.createDestinations(destinations, strategy);
        this.location = this.destinations.getFirst();
        createImage();
    }

    /**
     * returns location x value
     * @return
     */
    @Override
    public int getLocationX() {
        return location.getX();
    }

    /**
     * returns location y value
     * @return
     */
    @Override
    public int getLocationY() {
        return location.getY();
    }

    /**
     * creates an inmage for the house
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
     * updates the houses location if the truck arrives
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
     *
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
     * @return
     */
    public String letterLocation(int street)
    {
        return location.streetToLetter(street);
    }
}