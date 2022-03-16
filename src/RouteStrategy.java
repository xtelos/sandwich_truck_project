import java.util.LinkedList;

public interface RouteStrategy {

    /**
     * Sorts list of destinations based on specific strategy
     * @return
     */
    public void sortOrders(LinkedList<Location> destinations);

}
