import java.util.Comparator;

public class TimeComparator implements Comparator<Order>
{

    /**
     * compares two TimeStamps to determine which one occurs first
     * @param o1 = First TimeStamp
     * @param o2 = Second TimeStamp
     * @return
     *
     */
//    @Override
//    public int compare(TimeStamp o1, TimeStamp o2) {
//        if (o1.getHours() > o2.getHours())
//            return -1;
//        else if (o1.getHours() < o2.getHours())
//            return 1;
//        else {
//            if (o1.getMinutes() > o2.getMinutes())
//                return 1;
//            else if (o1.getMinutes() < o2.getMinutes())
//                return -1;
//        }
//        return 0;
//    }

    /**
     * Takes two orders and compares them to decide which order occurred first
     * @param o1 First order
     * @param o2 Second order
     * @return int
     */
    @Override
    public int compare(Order o1, Order o2) {
        TimeStamp o1TimeStamp = o1.getTimeStamp();
        TimeStamp o2TimeStamp = o2.getTimeStamp();

        if (o1TimeStamp.getHours() > o2TimeStamp.getHours())
            return -1;
        else if (o1TimeStamp.getHours() < o2TimeStamp.getHours())
            return 1;
        else {
            if (o1TimeStamp.getMinutes() > o2TimeStamp.getMinutes())
                return 1;
            else if (o1TimeStamp.getMinutes() < o2TimeStamp.getMinutes())
                return -1;
        }
        return 0;
    }
}

