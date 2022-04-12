/*
Class that implements the ordering of ketchup topping for a sandwich through the SandwichDecorator Decorator

Author: Devin McCormack
 */

public class Ketchup extends SandwichDecorator
{
    Sandwich sandwich;

    public Ketchup(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", ketchup";
    }

    public double cost() {
        return .25 + sandwich.cost();
    }
}
