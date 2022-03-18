import java.util.Collection;
import java.util.PriorityQueue;

public interface RouteStrategy {

    /**
     * Sorts list of destinations based on specific strategy
     * @return
     */
    PriorityQueue<Order> createRoute(Collection<Order> orders);

}
