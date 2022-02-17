import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Truck_Map extends Panel
{
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Vertical Streets
        g2d.drawLine(100, 0, 100, 1000);
        g2d.drawLine(200, 0, 200, 1000);
        g2d.drawLine(300, 0, 300, 1000);
        g2d.drawLine(400, 0, 400, 1000);
        g2d.drawLine(500, 0, 500, 1000);
        g2d.drawLine(600, 0, 600, 1000);
        g2d.drawLine(700, 0, 700, 1000);
        g2d.drawLine(800, 0, 800, 1000);
        g2d.drawLine(900, 0, 900, 1000);
        g2d.drawLine(1000, 0, 1000, 1000);

        // Horizontal Streets
        g2d.drawLine(0, 100, 1000, 100);
        g2d.drawLine(0, 200, 1000, 200);
        g2d.drawLine(0, 300, 1000, 300);
        g2d.drawLine(0, 400, 1000, 400);
        g2d.drawLine(0, 500, 1000, 500);
        g2d.drawLine(0, 600, 1000, 600);
        g2d.drawLine(0, 700, 1000, 700);
        g2d.drawLine(0, 800, 1000, 800);
        g2d.drawLine(0, 900, 1000, 900);
        g2d.drawLine(0, 1000, 1000, 1000);

    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}