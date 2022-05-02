import javax.swing.*;
import java.awt.*;

public interface Representations {

    /**
     * returns trucks x location value
     * @return int
     */
    public int getLocationX();

    /**
     * returns trucks y location value
     * @return int
     */
    public int getLocationY();

    /**
     * creates a buffered image
     */
    public void createImage();

    /**
     * updates representations location on the map
     */
    public void update();

    /**
     * paints representation on the map
     * @param g component to be painted
     */
    public void paintComponent(Graphics g);

}
