/*
Class that implements the ordering of lettuce topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Lettuce extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Lettuce added to the current sandwich
     * @param sandwich
     */
    public Lettuce(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding lettuce to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", lettuce";
    }

    /**
     * Returns the cost of current sandwich with the cost of the lettuce to it
     * @return Double
     */
    public double cost() {
        return .30 + sandwich.cost();
    }
}
