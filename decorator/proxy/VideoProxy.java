package proxy;

public class VideoProxy implements Video {
    private RealVideo video;
    private String filename;

    public VideoProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void play() {
        if (video == null) {
            video = new RealVideo(filename);
        }
        video.play();
    }
}