package objects;

public class ToppingsJalapeno extends ToppingsDecorator{

    Pizza pizza;

    public ToppingsJalapeno(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", халапеньо";
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.3;
    }
}