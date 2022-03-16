public class Main
{
    public static void main(String[] args)
    {
        TruckSim sim = new TruckSim(1000,1000);
        sim.runSim();

        OrderGenerator orderGenerator = new OrderGenerator();
        orderGenerator.generate(100);
    }
}