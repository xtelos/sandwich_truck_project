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

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getTimeStamp().getHours() > o2.getTimeStamp().getHours())
            return -1;
        else if (o1.getTimeStamp().getHours() < o2.getTimeStamp().getHours())
            return 1;
        else {
            if (o1.getTimeStamp().getMinutes() > o2.getTimeStamp().getMinutes())
                return 1;
            else if (o1.getTimeStamp().getMinutes() < o2.getTimeStamp().getMinutes())
                return -1;
        }
        return 0;
    }
}

