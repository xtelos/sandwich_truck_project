/*
Provides a class to add toppings to a Sandwich which implements the Decorator Design Pattern for Sandwich orders

Author: Jacob Smith
 */

/**
 * Returns description of the sandwich object along with its toppings
 */
public abstract class SandwichDecorator extends Sandwich {
    public abstract String getDescription();
}
