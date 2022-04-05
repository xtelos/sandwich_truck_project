/*
Class that implements the ordering of lettuce topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Lettuce extends SandwichDecorator
{
    Sandwich sandwich;

    public Lettuce(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", lettuce";
    }

    public double cost() {
        return .30 + sandwich.cost();
    }
}
