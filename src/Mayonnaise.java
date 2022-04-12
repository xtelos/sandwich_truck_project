/*
Class that implements the ordering of mayonnaise topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Mayonnaise extends SandwichDecorator
{
    Sandwich sandwich;

    public Mayonnaise(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", mayonnaise";
    }

    public double cost() {
        return .25 + sandwich.cost();
    }
}
