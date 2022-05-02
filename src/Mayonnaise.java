/*
Class that implements the ordering of mayonnaise topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Mayonnaise extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Mayonnaise added to the current sandwich
     * @param sandwich
     */
    public Mayonnaise(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding mayonnaise to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", mayonnaise";
    }

    /**
     * Returns the cost of current sandwich with the cost of the mayonnaise to it
     * @return Double
     */
    public double cost() {
        return .25 + sandwich.cost();
    }
}
