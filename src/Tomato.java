/*
Class that implements the ordering of tomato topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Tomato extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Tomato added to the current sandwich
     * @param sandwich
     */
    public Tomato(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding tomato to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", tomato";
    }

    /**
     * Returns the cost of current sandwich with the cost of the tomato to it
     * @return Double
     */
    public double cost() {
        return .40 + sandwich.cost();
    }
}
