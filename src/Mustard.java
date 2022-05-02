/*
Class that implements the ordering of mustard topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Mustard extends SandwichDecorator
{
    Sandwich sandwich;

    /**
     * Instantiates a SandwichDecorator topping of type Mustard added to the current sandwich
     * @param sandwich
     */
    public Mustard(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /**
     * Returns the description of the current sandwich while adding mustard to the description
     * @return String
     */
    public String getDescription() {
        return sandwich.getDescription() + ", mustard";
    }

    /**
     * Returns the cost of current sandwich with the cost of the mustard to it
     * @return Double
     */
    public double cost() {
        return .25 + sandwich.cost();
    }
}
