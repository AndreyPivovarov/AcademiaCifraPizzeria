package objects;

public class PizzaSizeOneAndHalf extends PizzaDecorator {

    Pizza pizza;

    public PizzaSizeOneAndHalf(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 30;
    }

    @Override
    public int getStandsrtSize() {
        return pizza.getStandsrtSize() + 15;
    }
}