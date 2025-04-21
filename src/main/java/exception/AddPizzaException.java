package exception;

public class AddPizzaException extends Exception {
  public AddPizzaException(int message) {
    super("Количество заказываемых блюд не должно превышать: " + message);
  }
}
