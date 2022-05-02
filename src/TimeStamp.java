/*
Class to represent a timestamp that contains the hour and the minutes

Author: Jacob Smith
 */

public class TimeStamp {

    private int hours;
    private int minutes;

    /**
     * Creates a TimeStamp using two ints in the parameter to fill in the private variables for hours and minutes
     * @param hours
     * @param minutes
     */
    public TimeStamp(int hours, int minutes) {
        if (hours > 1 && hours < 13) {
            this.hours = hours;
        }

        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        }
    }

    /**
     * Returns the hour of the time
     * @return: int
     *
     * Author: Jacob Smith
     */
    public int getHours() {
        return hours;
    }

    /**
     * Returns the minutes of the time
     * @return: int
     *
     * Author: Jacob Smith
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Returns the String that represents the time
     * @return: String
     *
     * Author: Jacob Smith
     */
    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

}
