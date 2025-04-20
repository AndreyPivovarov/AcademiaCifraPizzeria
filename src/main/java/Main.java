import objects.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exception.AddPizzaException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws AddPizzaException {
        Scanner sc = new Scanner(System.in);
        //создание фабрики
        PizzaFactory factory = new PizzaFactory();
        //создание пиццерии
        PizzaStore store = new PizzaStore(factory);
        //заказ пиццы конкретного вида
        print("Если желаете посмотреть меню нажмите - 1\n" +
                "Если желаете сделать заказ, введите любой другой символ.");
        if (sc.nextInt() == 1) {
            Menu menu = new Menu();
            menu.menuTable();
            return;
        }

        ArrayList<Pizza> pizzas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            try {
                if (i == 4) throw new AddPizzaException(i-1);
            } catch (AddPizzaException e) {
                System.out.println(e.getMessage());
                return;
            }

            print("Какую пиццу вы хотели бы закзать?\nСырная, Пепперони, Вегетарианская:");
            pizzas.add(i, store.orderPizza(sc.next()));

            pizzas.set(i, new ToppingsCheese(pizzas.get(i)));
            print("Введите размер пиццы (30/45/60 см):");
            pizzas.get(i).setStandsrtSize(sc.nextInt());
            print("Введите 'Далее' если готовы перейти к оформлению заказа\n" +
                    "Если желаете заказать еще что то, введите любой другой символ");
            if (sc.next().equals("Далее")) break;
        }
        pizzaCalculate(pizzas);

    }

    private static void pizzaCalculate(ArrayList<Pizza> pizzas) {
        print("Ваш заказ включает пиццу:");
        int total = 0;
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getName()+ " размером " + pizza.getStandsrtSize() + " по цене " + pizza.getPrice() + "$");
            total += pizza.getPrice();
        }
        print("Общая стоимость заказа = " + total + "$\n" +
                "Хотите продолжить?");
    }

    public static void print(String s) {
        System.out.println(s);
    }
}

