import java.util.ArrayList;
import java.util.PriorityQueue;

public interface RouteStrategy {

    /**
     * Sorts list of destinations based on specific strategy
     * @return
     */
    PriorityQueue<Location> createRoute(ArrayList<Order> orders);

}
