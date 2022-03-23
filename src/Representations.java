import javax.swing.*;
import java.awt.*;

public interface Representations {

    /**
     * returns turcks x location value
     * @return
     */
    public int getLocationX();

    /**
     * returns trucks y location value
     * @return
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
     * @param g
     */
    public void paintComponent(Graphics g);

}
