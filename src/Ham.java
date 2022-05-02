/*
Class that implements the ordering of a ham sandwich through the Sandwich Decorator

Author: Devin McCormack
 */

public class Ham extends Sandwich
{
    /**
     * Instantiates a sandwich of type ham
     */
    public Ham() {
        description = "Ham";
    }

    /**
     * Returns the String description of the ham sandwich
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the cost of the ham sandwich
     * @return Double
     */
    public double cost() {
        return 1.50;
    }
}
