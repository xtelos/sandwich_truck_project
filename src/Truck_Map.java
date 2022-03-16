/*
Class used for generating the basic drawn components of the Jframe Truck_Map. Components can be added in various
methods and then added to paint() in other to be drawn on the JFrame.
 */

import java.awt.*;
import java.util.LinkedList;

public class Truck_Map extends Panel
{
    public TruckDot truck;
    public ServiceCenterDot serviceCenter;
    /*
    Draws the basic gridlines on the JFrame, which are used to position addresses
     */
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


    /**
     * creates the service center and a basic truck to check if movement works
     */
    public void createRepresentations()
    {
        Location location = new Location(500, 500);
        Location destination1 = new Location(600, 500);
        Location destination2 = new Location(600, 600);

        LinkedList<Location> destinations = new LinkedList<>();
        destinations.add(destination1);
        destinations.add(destination2);

        RouteStrategy strategy = new TimeStrategy();

        truck = new TruckDot(location, destinations, strategy);
        serviceCenter = new ServiceCenterDot();
    }

    /**
     * Calls TruckDot's update so that TruckSim does not need to deal with the TruckDot class
     */
    public void update(){
        truck.update();
    }

    /*
    Method used to control the drawing components on the JFrame
     */
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
        truck.paintComponent(g);
        serviceCenter.paint(g);
        }

    }