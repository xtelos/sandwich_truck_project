/*
Comparator to compare the distances of two Location objects from the Service Center

Author: Jacob Smith
 */
import java.util.Comparator;

public class DistanceComparator implements Comparator<Location> {


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
    public int compare(Location o1, Location o2) {
        Location serviceCenter = new Location(500,500);

        if (o1.distance(o1, serviceCenter) < o2.distance(o2, serviceCenter))
            return -1;
        else if (o1.distance(o1, serviceCenter) > o2.distance(o2, serviceCenter))
            return 1;
        return 0;
    }
}
