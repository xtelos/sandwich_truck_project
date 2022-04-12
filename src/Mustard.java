/*
Class that implements the ordering of mustard topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Mustard extends SandwichDecorator
{
    Sandwich sandwich;

    public Mustard(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", mustard";
    }

    public double cost() {
        return .25 + sandwich.cost();
    }
}
