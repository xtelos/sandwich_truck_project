/*
Class that implements the ordering of a bun for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Bun extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Bun added to the current sandwich
     * @param sandwich
     */
    public Bun(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding bun to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", bun";
    }

    /**
     * Returns the cost of current sandwich with the cost of the bun to it
     * @return Double
     */
    public double cost() {
        return .50 + sandwich.cost();
    }
}
