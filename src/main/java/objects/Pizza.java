package objects;

import java.util.ArrayList;

public abstract class Pizza {
    private String name; //название
    private double price; //цена
    private int standsrtSize; //размер пиццы

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStandsrtSize() {
        return standsrtSize;
    }

    public void setStandsrtSize(int standsrtSize) {
        this.standsrtSize = standsrtSize;
    }

    @Override
    public String toString() {
        return  "Пицца=" + getName() +
                ", цена=" + getPrice() +
                ", стандартный размер=" + getStandsrtSize();
    }
}