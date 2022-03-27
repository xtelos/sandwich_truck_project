/*
Comparator to compare the distances of two Location objects from the Service Center

Author: Jacob Smith
 */
import java.util.Comparator;

public class DistanceComparator implements Comparator<Order> {


    /**
     * Compares two locations' distances from the service center
     *
     * @param o1 Location 1
     * @param o2 Location 2
     * @return integer, 1 for o1 further, -1 for o1 closer, 0 for same distance
     *
     * Author: Jacob Smith
     */
    @Override
    public int compare(Order o1, Order o2) {
        Location serviceCenter = new Location(500,500);

        Location o1Location = o1.convertToLocation();
        Location o2Location = o2.convertToLocation();

        if (o1Location.distance(o1Location, serviceCenter) < o2Location.distance(o2Location, serviceCenter))
            return -1;
        else if (o1Location.distance(o1Location, serviceCenter) > o2Location.distance(o2Location, serviceCenter))
            return 1;
        return 0;
    }
}
