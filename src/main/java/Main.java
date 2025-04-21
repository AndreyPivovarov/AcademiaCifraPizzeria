import objects.*;

import java.util.Scanner;

import static objects.OrdersPizza.start;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //создание фабрики
        PizzaFactory factory = new PizzaFactory();
        //создание пиццерии
        PizzaStore store = new PizzaStore(factory);
        //создание заказа
        OrdersPizza order1 = new OrdersPizza();

        if (start(sc)) return;
        order1.order(sc, store);
    }
}