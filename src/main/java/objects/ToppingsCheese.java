package objects;

public class ToppingsCheese extends ToppingsDecorator{

    Pizza pizza;

    public ToppingsCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", сыр";
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.2;
    }
}
