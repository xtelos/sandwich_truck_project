public class TimeStamp {

    private int hours;
    private int minutes;

    public TimeStamp(int hours, int minutes) {
        if (hours > 1 && hours < 13) {
            this.hours = hours;
        }

        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

}
