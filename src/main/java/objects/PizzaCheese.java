package objects;

public class PizzaCheese extends PizzaDecorator {

    Pizza pizza;

    public PizzaCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", сыр";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 20;
    }

    @Override
    public int getStandsrtSize() {
        return pizza.getStandsrtSize();
    }
}
