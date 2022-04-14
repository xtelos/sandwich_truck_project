import javax.swing.*;

public class TruckSim extends JFrame{

    private TruckMap truckMap;
    public Truck truck;
    public ServiceCenter serviceCenter;
    public RedHouse redHouse;



    /**
     * creates JFrame of neighborhood with input length and with of window
     */
    TruckSim(RouteStrategy strategy){

        setSize(1500,1000);
        this.truckMap = new TruckMap(strategy);

        setContentPane(truckMap);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Creates truck and service center, and makes the truck change location to reach destination
     */
    public void runSim() {

        while (truckMap.truckHasOrders()) {
            truckMap.update();
            truckMap.paint(truckMap.getGraphics());

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
            }
        }
    }
}