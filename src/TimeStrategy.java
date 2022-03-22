import java.util.ArrayList;

import java.util.PriorityQueue;

public class TimeStrategy implements RouteStrategy{

    /**
     * sorts linked list destinations by time priority
     * @param orders
     */
    @Override
    public PriorityQueue<Location> createRoute(ArrayList<Order> orders) {
        // instantiate PriorityQueue<Location>(TimeStampComparator) queue
        // queue.add(order.convertToLocation());
        return null;
    }
}
