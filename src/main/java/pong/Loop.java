package pong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Loop implements Runnable {
    Rect p1Paddle, p2Paddle;
    Ball ball;
    PlayerController p1Control, p2Control;
    UI ui;
    GameState state;
    NumberSprites nums = new NumberSprites();

    boolean IS_MULTIPLAYER = false;

    @Override
    public void run() {
        ui = UI.getInstance();
        state = GameState.getInstance();
        state.newGame();
        initPlayersAndBall();
        ui.initWindow();

        double lastFrameTime = Time.getTime();
        while (true) {
            double now = Time.getTime();
            double deltaTime = now - lastFrameTime;
            lastFrameTime = now;
            update(deltaTime);
        }
    }

    public void update(double dt) {
        ui.createDbImage();
        Graphics2D dbg = ui.getDbGraphics();

        p1Control.update(dt);
        p2Control.update(dt);
        ball.update(dt);

        ui.setBackground(dbg);
        p1Paddle.draw(dbg);
        p2Paddle.draw(dbg);
        ball.draw(dbg);
        nums.drawRect(state.getP1Score(), 100, 100, dbg);
        nums.drawRect(state.getP2Score(), Constants.WINDOW_W - 100, 100, dbg);

        ui.drawDbImg();
    }

    private void initPlayersAndBall() {
        double screenCenterY = (double) Constants.WINDOW_H / 2;
        double paddleStartY = screenCenterY - Constants.PADDLE_H / 2;
        p1Paddle = new Rect(
                Constants.PADDLE_PADDING,
                paddleStartY,
                Constants.PADDLE_W,
                Constants.PADDLE_H
        );
        p2Paddle = new Rect(
                Constants.WINDOW_W - Constants.PADDLE_PADDING - Constants.PADDLE_W,
                paddleStartY,
                Constants.PADDLE_W,
                Constants.PADDLE_H
        );
        ball = new Ball(
                Constants.BALL_SIZE,
                Constants.BALL_SIZE,
                p1Paddle,
                p2Paddle
        );
        p1Control = new PlayerController(p1Paddle, KeyEvent.VK_W, KeyEvent.VK_S);
        p2Control = IS_MULTIPLAYER
                ? new PlayerController(p2Paddle, KeyEvent.VK_UP, KeyEvent.VK_DOWN)
                : new AI(p2Paddle, ball);
    }
}
