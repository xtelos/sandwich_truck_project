import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Truck_Map");
        frame.getContentPane().add(new Truck_Map());
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        AddressBook addressBook = new AddressBook();
        addressBook.generate(100);
    }
}