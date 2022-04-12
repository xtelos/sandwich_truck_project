/*
Class that implements the ordering of a ham sandwich through the Sandwich Decorator

Author: Devin McCormack
 */

public class Ham extends Sandwich
{
    public Ham() {
        description = "Ham";
    }

    public String getDescription() {
        return description;
    }

    public double cost() {
        return 1.50;
    }
}
