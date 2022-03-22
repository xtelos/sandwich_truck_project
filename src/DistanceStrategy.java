/*
Class to implement the strategy to deliver orders that are closest to the service center

Author: Jacob Smith
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DistanceStrategy implements RouteStrategy{

    private PriorityQueue<Location> queue;

    public DistanceStrategy() {
        queue = new PriorityQueue<>(new DistanceComparator());
    }

    /**
     * sorts ArrayList<Order> of destinations by distance priority
     * @param orders
     */
    @Override
    public PriorityQueue<Location> createRoute(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            queue.add(orders.get(i).convertToLocation());
        }
        return queue;
    }
}
