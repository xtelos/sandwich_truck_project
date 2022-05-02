/*
Class that implements the ordering of bread for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Bread extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Bread added to the current sandwich
     * @param sandwich
     */
    public Bread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding bread to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", bread";
    }

    /**
     * Returns the cost of current sandwich with the cost of the bread to it
     * @return Double
     */
    public double cost() {
        return .35 + sandwich.cost();
    }
}
