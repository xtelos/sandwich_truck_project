/*
Class that implements the ordering of a turkey sandwich through the Sandwich Decorator

Author: Devin McCormack
 */

public class Turkey extends Sandwich
{
    /**
     * Instantiates a sandwich of type turkey
     */
    public Turkey() {
        description = "Turkey";
    }

    /**
     * Returns the String description of the turkey sandwich
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the cost of the turkey sandwich
     * @return Double
     */
    public double cost() {
        return 2.00;
    }
}
