package pong;

public class Time {
    public static final long startTime = System.nanoTime();

    public static double getTime() {
        return (System.nanoTime() - startTime) * 1E-9;
    }
}
