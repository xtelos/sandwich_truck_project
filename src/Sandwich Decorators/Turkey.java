/*
Class that implements the ordering of a turkey sandwich through the Sandwich Decorator

Author: Devin McCormack
 */

public class Turkey extends Sandwich
{
    public Turkey() {
        description = "Turkey";
    }

    public String getDescription() {
        return description;
    }

    public double cost() {
        return 2.00;
    }
}
