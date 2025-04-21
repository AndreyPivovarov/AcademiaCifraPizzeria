package objects;

public class PizzaСucumber extends PizzaDecorator {

    Pizza pizza;

    public PizzaСucumber(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", огурец";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 15;
    }

    @Override
    public int getStandsrtSize() {
        return pizza.getStandsrtSize();
    }
}