package proxy;

public class RealVideo implements Video {
    private String filename;

    public RealVideo(String filename) {
        this.filename = filename;
        System.out.println("Loading " + filename);
    }

    @Override
    public void play() {
        System.out.println("Playing " + filename);
    }
}