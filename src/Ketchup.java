/*
Class that implements the ordering of ketchup topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Ketchup extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Ketchup added to the current sandwich
     * @param sandwich
     */
    public Ketchup(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding ketchup to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", ketchup";
    }

    /**
     * Returns the cost of current sandwich with the cost of the ketchup to it
     * @return Double
     */
    public double cost() {
        return .25 + sandwich.cost();
    }
}
