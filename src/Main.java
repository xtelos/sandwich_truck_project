import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        TruckSim sim = new TruckSim(1000,1000);
        sim.runSim();

        HashSet<Order> orders = new HashSet<>();
        try {
            File file = new File("orders.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Couldn't read file");
        }
    }
}