package proxy;

public class Main {
    public static void main(String[] args) {
        Video video = new VideoProxy("movie.mp4");

        System.out.println("Proxy created");

        video.play();
        video.play();
    }
}