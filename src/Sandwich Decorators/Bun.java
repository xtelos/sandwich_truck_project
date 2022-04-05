/*
Class that implements the ordering of a bun for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Bun extends SandwichDecorator
{
    Sandwich sandwich;

    public Bun(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", bun";
    }

    public double cost() {
        return .50 + sandwich.cost();
    }
}
