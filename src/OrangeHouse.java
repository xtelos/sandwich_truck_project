import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class OrangeHouse extends JPanel implements Representations {

    public Location location;
    public LinkedList<Location> destinations;
    public BufferedImage image;

    OrangeHouse(LinkedList<Location> destinations){
        this.destinations = destinations;
        this.location = this.destinations.getFirst();
        createImage();
    }

    /**
     * Getter for x value of location
     * @return location
     */
    @Override
    public int getLocationX() {
        return location.getX();
    }

    /**
     * Getter for y value of location
     * @return
     */
    @Override
    public int getLocationY() {
        return location.getY();
    }

    /**
     * Creates image for the house
     */
    @Override
    public void createImage() {
        try {
            image = ImageIO.read(new File("images/HouseType1.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the house location if the truck arrives
     */
    @Override
    public void update() {

    }

    /**
     * paints the house
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,location.getX()-10,location.getY()-10,20,20,null);
    }
}
