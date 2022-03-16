import javax.swing.*;

public class TruckSim extends JFrame {

    private Truck_Map truckMap;

    /**
     * creates JFrame of neighborhood with input length and with of window
     * @param length
     * @param width
     */
    TruckSim(int length, int width){

        setSize(length,width);
        truckMap = new Truck_Map();

        setContentPane(truckMap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Creates truck and service center, and makes the truck change location to reach destination
     */
    public void runSim() {
        int i = 0;
        truckMap.createRepresentations();
        while (i < 1) {
            truckMap.update();
            truckMap.repaint();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
            }
        }
    }
}
