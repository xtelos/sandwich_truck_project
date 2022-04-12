/*
Class that implements the ordering of tomato topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Tomato extends SandwichDecorator
{
    Sandwich sandwich;

    public Tomato(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", tomato";
    }

    public double cost() {
        return .40 + sandwich.cost();
    }
}
