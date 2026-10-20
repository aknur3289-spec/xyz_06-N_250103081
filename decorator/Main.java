package decorator;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pineapple(
                new Olives(
                        new Cheese(
                                new PlainPizza()
                        )
                )
        );

        System.out.println(pizza.getDescription());
        System.out.println("Total cost: $" + pizza.getCost());
    }
}