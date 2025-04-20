package objects;

public class PepperoniPizza extends Pizza {
    private String name = "Пепперони";
    private double price = 90;
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
    public void setPrice(int price) {
        this.price = price;
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
