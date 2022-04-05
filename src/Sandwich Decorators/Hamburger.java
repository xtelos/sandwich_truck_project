/*
Class that implements the ordering of a hamburger through the Sandwich Decorator

Author: Devin McCormack
 */

public class Hamburger extends Sandwich
{
    public Hamburger() {
        description = "Hamburger";
    }

    public String getDescription() {
        return description;
    }

    public double cost() {
        return 2.00;
    }
}
