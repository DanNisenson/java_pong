package pong;

import java.awt.*;

public class Constants {
    public static final String WINDOW_TITLE = "Pong";
    public static final Color SCREEN_COLOR = Color.WHITE;
    public static final Color SCREEN_BG = Color.BLACK;

    public static final int WINDOW_H = 800;
    public static final int WINDOW_W = (WINDOW_H / 3) * 4;

    public static final int PADDLE_PADDING = 10;
    public static final double PADDLE_W = 10;
    public static final double PADDLE_H = 100;
    public static final double PADDLE_SPEED = 300;

    public static final int BALL_SIZE = 10;
    public static final double BALL_SPEED = 350;
    public static final double BALL_MAX_ANGLE = 45;
    public static final double BALL_ACCELERATION = 1.1;

    public static int INSETS_TOP;

}
