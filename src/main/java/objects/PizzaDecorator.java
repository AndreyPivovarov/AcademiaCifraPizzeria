package objects;

public abstract class PizzaDecorator extends Pizza{
    @Override
    public abstract String getName();

    @Override
    public abstract double getPrice();

    @Override
    public int getStandsrtSize() {
        return super.getStandsrtSize();
    }
}
