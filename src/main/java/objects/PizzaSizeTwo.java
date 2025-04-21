package objects;

public class PizzaSizeTwo extends PizzaDecorator {

    Pizza pizza;

    public PizzaSizeTwo(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 60;
    }

    @Override
    public int getStandsrtSize() {
        return pizza.getStandsrtSize() + 30;
    }
}