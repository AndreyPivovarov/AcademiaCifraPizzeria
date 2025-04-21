package objects;

/**
 * Класс создания конкретной пиццы
 */

public class PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("Сырная")) {
            pizza = new CheesePizza();
        } else if (type.equals("Пепперони")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("Вегетарианская")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
