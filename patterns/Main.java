public class Main {
    public static void main(String[] args) {

        // DECORATOR
        System.out.println("DECORATOR PATTERN");

        Pizza pizza = new Pineapple(
                new Olives(
                        new Cheese(new PlainPizza())));

        System.out.println(pizza.getDescription());
        System.out.println("Total: $" + pizza.getCost());

        // PROXY
        System.out.println("\nPROXY PATTERN");

        Video video = new VideoProxy("movie.mp4");
        video.play();
        video.play();

        // BRIDGE
        System.out.println("\nBRIDGE PATTERN");

        Shape redCircle = new Circle(new Red());
        Shape blueCircle = new Circle(new Blue());

        redCircle.draw();
        blueCircle.draw();
    }
}