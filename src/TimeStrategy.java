import java.util.ArrayList;

import java.util.PriorityQueue;

public class TimeStrategy implements RouteStrategy{

    private PriorityQueue<Order> queue;

    /**
     * Instantiates the order queue using a PriorityQueue with a TimeComparator for its parameter to carry out
     * the TimeStrategy
     */
    public TimeStrategy() {
        queue = new PriorityQueue<>(new TimeComparator());
    }

    /**
     * sorts linked list destinations by time priority
     * @param orders
     */
    @Override
    public PriorityQueue<Order> createRoute(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            queue.add(orders.get(i));
        }
        return queue;
    }
}
