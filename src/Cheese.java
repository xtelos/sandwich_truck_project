/*
Class that implements the ordering of cheese topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Cheese extends SandwichDecorator
{
    Sandwich sandwich;

    public Cheese(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", cheese";
    }

    public double cost() {
        return .75 + sandwich.cost();
    }
}
