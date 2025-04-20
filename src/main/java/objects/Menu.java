package objects;

import java.util.ArrayList;

public class Menu {
    public void menuTable(){
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new CheesePizza());
        pizzas.add(new PepperoniPizza());
        pizzas.add(new VeggiePizza());
        System.out.println(pizzas);
        System.out.println("При заказе пиццы диаметром 40 см, стоимость пиццы будет выше на 20%\n" +
                "При заказе пиццы диаметром 50 см, стоимость пиццы будет выше на 40%");
    }


}
