import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Time;

public class OptionsMenu extends JFrame implements ActionListener {
    public JPanel panel;
    public JButton distanceButton;
    public JButton timeButton;
    public JButton addOrderButton;
    public JTextField orderText;

    public OptionsMenu()
    {
        setSize(1500,1500);
        panel = new JPanel();

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * creates buttons for strategy selection
     */
    public void createButtons(){
        panel.setLayout(null);
        distanceButton = new JButton("Distance Strategy");
        distanceButton.addActionListener(this);
        distanceButton.setBounds(200, 10, 500,300);
        panel.add(distanceButton);
        timeButton = new JButton("Time Strategy");
        timeButton.addActionListener(this);
        timeButton.setBounds(200, 310, 500, 300);
        panel.add(timeButton);
        addOrderButton = new JButton("Add Order");
        addOrderButton.addActionListener(this);
        addOrderButton.setBounds(800, 150, 100, 50);
        panel.add(addOrderButton);
        orderText = new JTextField("Enter Order");
        orderText.setBounds(800, 100, 300,25);
        panel.add(orderText);
        setVisible(true);
    }

    /**
     * runs sim based on button selection
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == distanceButton) {
            this.dispose();
            TruckSim sim = new TruckSim(new DistanceStrategy());
            sim.runSim();
        }

        else if (e.getSource() == timeButton)
        {
            this.dispose();
            TruckSim sim = new TruckSim(new TimeStrategy());
            sim.runSim();
        }
        else{
            // Orders must be in format of 999 M Street,9:99,Ham Sandwich
            try {
                try {
                    File file = new File("orders.txt");
                    FileWriter fileWriter = new FileWriter(file, true);
                    fileWriter.write(orderText.getText() + "\n");
                    fileWriter.close();
                }
                catch (IOException fileNotFound) {
                    System.out.println("Could not open file");
                    fileNotFound.printStackTrace();
                }
                orderText.setText("Enter Order");
            }
            catch (Exception n)
            {
                orderText.setText("Invalid Text, Enter Another Order");
            }
        }
    }

}

