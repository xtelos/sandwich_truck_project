/*
Class that implements the ordering of a hamburger through the Sandwich Decorator

Author: Devin McCormack
 */

public class Hamburger extends Sandwich
{
    /**
     * Instantiates a sandwich of type Hamburger
     */
    public Hamburger() {
        description = "Hamburger";
    }

    /**
     * Returns the String description of the hamburger
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the cost of the hamburger
     * @return Double
     */
    public double cost() {
        return 2.00;
    }
}
