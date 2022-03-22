import java.util.Comparator;

public class DistanceComparator implements Comparator<Location> {

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
