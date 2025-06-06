package objects;

import exception.AddPizzaException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrdersPizza {

    /**
     * Метод создания заказа
     */
    public static void order(Scanner sc, PizzaStore store) {
        ArrayList<Pizza> pizzas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            if (i == 4) {
                limit(i); // лимит на количество блюд
                return;
            }

            print("Какую пиццу вы хотели бы закзать?\nСырная, Пепперони, Вегетарианская:");
            pizzas.add(i, store.orderPizza(sc.next()));
            print("Введите размер пиццы (30/45/60 см):");
            switch (sc.nextInt()) {
                case (30) -> pizzas.get(i).setStandsrtSize(30);
                case (45) -> pizzas.set(i, new PizzaSizeOneAndHalf(pizzas.get(i)));
                case (60) -> pizzas.set(i, new PizzaSizeTwo(pizzas.get(i)));
                default -> throw new IllegalStateException("Вы указали неверный размер пиццы");
            }

            print("Желаете добавить к пицце добавки?\nЕсли не желаете введите 'Далее', иначе:\nСыр, Огурец, Халапеньо:");
            toppings(sc, pizzas, i);

            print("Введите 'Далее' если готовы перейти к оформлению заказа\n" +
                    "Если желаете заказать еще что то, введите любой другой символ");
            if (sc.next().equals("Далее")) break;
        }
        pizzaCalculate(pizzas);
    }

    /**
     *
     * Метод добавления добавок в пиццу
     * @param pizzas заказ
     * @param i пицца
     */
    private static void toppings(Scanner sc, ArrayList<Pizza> pizzas, int i) {
        String input = sc.next();
        while (!input.equals("Далее")) {
            switch (input) {
                case ("Сыр") -> pizzas.set(i, new PizzaCheese(pizzas.get(i)));
                case ("Огурец") -> pizzas.set(i, new PizzaСucumber(pizzas.get(i)));
                case ("Халапеньо") -> pizzas.set(i, new PizzaJalapeno(pizzas.get(i)));
                default -> throw new IllegalStateException("Вы указали неверное название добавки");
            }
            print("Если добавки больше не нужны, нажмите 'Далее'\nЕсли желаете еще добавки, введите:\nСыр, Огурец, Халапеньо:");
            input = sc.next();
        }
    }

    /**
     * Метод вывода предупреждения о превышении лимита блюд в заказе
     *
     * @param i лимит на количество заказов (задается из точки вызова метода)
     */

    public static void limit(int i) {
        try {
            throw new AddPizzaException(i);
        } catch (AddPizzaException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод вывода меню пиццерии
     */

    public static boolean start(Scanner sc) {
        print("""
                Если желаете посмотреть меню нажмите - 1
                Если хотите выйти из программы нажмите - 2
                Если желаете сделать заказ, введите любое другое число.""");
        int option = 0;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число!");
            return true;
        }

        if (option == 1) {
            Menu menu = new Menu();
            menu.menuTable();
            return true;
        }
        if (option == 2) {
            return true;
        }
        return false;
    }

    /**
     * Метод подтверждения заказа: вывод информации о заказанных блюдах
     *
     * @param pizzas список заказанных блюд
     */

    public static void pizzaCalculate(ArrayList<Pizza> pizzas) {
        print("Ваш заказ включает пиццу:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getName() + " размером " + pizza.getStandsrtSize() + " см, по цене " + pizza.getPrice() + "$");
        }
        print("Общая стоимость заказа = " + total(pizzas) + "$\n" +
                "Хотите продолжить?");
    }

    /**
     * Метод рассчета общей стоимости заказа
     *
     * @param pizzas список заказанных блюд
     */

    public static double total(ArrayList<Pizza> pizzas) {
        double sum = 0;
        for (Pizza pizza : pizzas) {
            sum += pizza.getPrice();
        }
        return sum;
    }

    public static void print(String s) {
        System.out.println(s);
    }
}

