/*
Class that implements the ordering of bread for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Bread extends SandwichDecorator
{
    Sandwich sandwich;

    public Bread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", bread";
    }

    public double cost() {
        return .35 + sandwich.cost();
    }
}
