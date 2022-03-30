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

    RedHouse(LinkedList<Location> destinations){
        this.destinations = destinations;
        this.location = this.destinations.getFirst();
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

    @Override
    public void createImage() {
        try {
            image = ImageIO.read(new File("src/HouseType2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        destinations.removeFirst();
        location = destinations.getFirst();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,location.getX(),location.getY(),20,20,null);
    }
}
