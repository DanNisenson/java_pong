package pong;

public class Main {
    public static void main(String[] args) {
        Loop loop = new Loop();
        Thread thread = new Thread(loop);
        thread.start();
    }
}
