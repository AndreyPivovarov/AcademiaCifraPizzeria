import objects.*;
import exception.AddPizzaException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //создание фабрики
        PizzaFactory factory = new PizzaFactory();
        //создание пиццерии
        PizzaStore store = new PizzaStore(factory);

        if(start(sc)) return;
        order(sc, store);
    }

    /**
     * Метод создания заказа
     * @param store пиццерия
     */
    private static void order(Scanner sc, PizzaStore store) {
        ArrayList<Pizza> pizzas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            if (i == 4) {
                limit(i);
                return;
            }

            print("Какую пиццу вы хотели бы закзать?\nСырная, Пепперони, Вегетарианская:");
            pizzas.add(i, store.orderPizza(sc.next()));
            print("Введите размер пиццы (30/45/60 см):");
//            pizzas.get(i).setStandsrtSize(sc.nextInt());
            switch (sc.nextInt()) {
                case (30):
                    pizzas.get(i).setStandsrtSize(30);
                    break;
                case (45):
                    pizzas.set(i, new PizzaSizeOneAndHalf(pizzas.get(i)));
                    break;
                case (60):
                    pizzas.set(i, new PizzaSizeTwo(pizzas.get(i)));
                    break;
                default:
                    throw new IllegalStateException("Вы указали неверный размер пиццы");
            }

            pizzas.set(i, new PizzaCheese(pizzas.get(i)));
            pizzas.set(i, new PizzaСucumber(pizzas.get(i)));
            pizzas.set(i, new PizzaJalapeno(pizzas.get(i)));

            print("Введите 'Далее' если готовы перейти к оформлению заказа\n" +
                    "Если желаете заказать еще что то, введите любой другой символ");
            if (sc.next().equals("Далее")) break;
        }
        pizzaCalculate(pizzas);

    }

    /**
     * Метод вывода предупреждения о превышении лимита блюд в заказе
     * @param i лимит на количество заказов (задается из точки вызова метода)
     */

    private static void limit(int i) {
        try {
            throw new AddPizzaException(i);
        } catch (AddPizzaException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод вывода меню пиццерии
     */

    private static boolean start(Scanner sc) {
        print("Если желаете посмотреть меню нажмите - 1\n" +
                "Если хотите выйти из программы нажмите - 2\n" +
                "Если желаете сделать заказ, введите любое другое число.");
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
     * Метод подтверждения заказа: вывод информации о заказанных блюдах и расчет общей стоимости
     * @param pizzas список заказанных блюд
     */

    private static void pizzaCalculate(ArrayList<Pizza> pizzas) {
        print("Ваш заказ включает пиццу:");
        double total = 0;
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getName() + " размером " + pizza.getStandsrtSize() + " по цене " + pizza.getPrice() + "$");
            total += pizza.getPrice();
        }
        print("Общая стоимость заказа = " + total + "$\n" +
                "Хотите продолжить?");
    }

    public static void print(String s) {
        System.out.println(s);
    }
}

