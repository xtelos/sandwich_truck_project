import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DistanceStrategy implements RouteStrategy{

    /**
     * sorts linked list destinations by distance priority
     * @param orders
     */
    @Override
    public PriorityQueue<Order> createRoute(Collection<Order> orders) {
        PriorityQueue<Order> queue = new PriorityQueue<>();
        return queue;
    }
}
