import javax.swing.*;

public class TruckSim extends JFrame {

    private TruckMap truckMap;

    /**
     * creates JFrame of neighborhood with input length and with of window
     * @param length
     * @param width
     */
    TruckSim(int length, int width){
        setSize(length,width);
        truckMap = new TruckMap();

        setContentPane(truckMap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Creates truck and service center, and makes the truck change location to reach destination
     */
    public void runSim() {
        while (truckMap.truckHasOrders()) {
            truckMap.update();
            truckMap.repaint();

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException ex) {
            }
        }
    }
}
