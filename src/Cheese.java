/*
Class that implements the ordering of cheese topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Cheese extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Cheese added to the current sandwich
     * @param sandwich
     */
    public Cheese(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding cheese to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", cheese";
    }

    /**
     * Returns the cost of current sandwich with the cost of the cheese to it
     * @return Double
     */
    public double cost() {
        return .75 + sandwich.cost();
    }
}
