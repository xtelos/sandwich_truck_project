import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ServiceCenter extends JPanel implements Representations{

    private Location location;
    public BufferedImage image;

    /**
     * Constructor without a specific start location
     */
    ServiceCenter() {
        this.location = new Location(500,500);
        createImage();
    }

    /**
     * returns x value of the location
     * @return
     */
    @Override
    public int getLocationX() {
        return location.getX();
    }

    /**
     * returns y value of the location
     * @return
     */
    @Override
    public int getLocationY() {
        return location.getY();
    }

    /**
     * creates the service center image
     */
    @Override
    public void createImage() {
        try {
            image = ImageIO.read(new File("images/ServiceCenter.jpeg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Empty update(), as the service center will not need to be moved during operation
     */
    @Override
    public void update() {
    }


    public String letterLocation(int street)
    {
        return location.streetToLetter(street);
    }

    /**
     * Places the service center on the map as a blue dot
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,location.getX()-20,location.getY()-20,20,20,null);

    }
}