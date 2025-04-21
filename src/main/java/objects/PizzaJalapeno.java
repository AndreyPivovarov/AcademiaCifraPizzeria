package objects;

public class PizzaJalapeno extends PizzaDecorator {

    Pizza pizza;

    public PizzaJalapeno(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return pizza.getName() + ", халапеньо";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 25;
    }
}