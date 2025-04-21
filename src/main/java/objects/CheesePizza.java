package objects;

public class CheesePizza extends Pizza {
    private String name = "Сырная";
    private double price = 100;
    private int standsrtSize = 30;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getStandsrtSize() {
        return standsrtSize;
    }

    @Override
    public void setStandsrtSize(int standsrtSize) {
        this.standsrtSize = standsrtSize;
    }
}
