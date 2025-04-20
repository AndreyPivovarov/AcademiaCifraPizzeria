package objects;

/**
 * Класс создания пиццы
 */

public class PizzaStore {

    private PizzaFactory factory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.factory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type); //создание экземпляра конкретного вида
        //pizza.prepare();
        return pizza;
    }
}

