package objects;

public class VeggiePizza extends Pizza {
    private String name = "Вегетарианская";
    private double price = 80;
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
