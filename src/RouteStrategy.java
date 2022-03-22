/*
Interface to implement the Strategy Design Pattern for the truck to be able to choose which
kind of strategy it would like to use to deliver the orders

Author: Jacob Smith
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public interface RouteStrategy {

    /**
     * Sorts list of destinations based on specific strategy
     * @return: PriorityQueue of Location objects
     */
    PriorityQueue<Location> createRoute(ArrayList<Order> orders);

}
