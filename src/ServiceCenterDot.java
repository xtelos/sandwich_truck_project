import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ServiceCenterDot implements Representations{

    private Location location;
    BufferedImage image;

    /**
     * Constructor without a specific start location
     */
    ServiceCenterDot() {
        Location location = new Location(490,490);
        this.location = location;
        //createImage();
    }

    @Override
    public int getLocationX() {
        return 0;
    }

    @Override
    public int getLocationY() {
        return 0;
    }

    @Override
    public void createImage() {
//        try {
//            image = ImageIO.read(new File("/Users/vitoleone1127/CS234/sandwich_truck_project/src/FoodTruckIcon.jpeg"));
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Empty update(), as the service center will not need to be moved during operation
     */
    @Override
    public void update() {
    }

    /**
     * Places the service center on the map as a blue dot
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(location.getX() - 10, location.getY() - 10, 20, 20);

    }
}