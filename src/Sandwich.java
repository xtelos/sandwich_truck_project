/*
Abstract class that represents a Sandwich object for orders to the truck

Author: Jacob Smith
 */

public abstract class Sandwich {

    String description = "Unknown Sandwich";

    /**
     * Returns the description of the Sandwich to the caller
     *
     * @return: String
     *
     * Author: Jacob Smith
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the cost of the Sandwich to the caller
     * 
     * @return: double
     *
     * Author: Jacob Smith
     */
    public abstract double cost();
}
