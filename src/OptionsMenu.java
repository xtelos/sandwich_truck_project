import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsMenu extends JFrame implements ActionListener {
    public JPanel panel;
    public JButton distanceButton;
    public JButton timeButton;

    public OptionsMenu()
    {
        setSize(1000,1000);
        panel = new JPanel();

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == distanceButton) {
            this.dispose();
            TruckSim sim = new TruckSim(new DistanceStrategy());
            sim.runSim();
        }

        else
        {
            this.dispose();
            TruckSim sim = new TruckSim(new TimeStrategy());
            sim.runSim();
        }
    }
}
