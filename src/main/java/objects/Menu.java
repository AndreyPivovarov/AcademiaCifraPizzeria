package objects;

import java.util.ArrayList;

/**
 * Класс отображения меню пиццерии
 */
public class Menu {
    public void menuTable(){
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new CheesePizza());
        pizzas.add(new PepperoniPizza());
        pizzas.add(new VeggiePizza());
        System.out.println(pizzas);
        System.out.println("При заказе пиццы диаметром 40 см, стоимость пиццы будет выше на 30 $\n" +
                "При заказе пиццы диаметром 50 см, стоимость пиццы будет выше на 60$\n" +
                "Добавки: сыр 20 $, халапеньо 25 $, огурцы 15 $");
    }


}
