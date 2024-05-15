package pong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Loop implements Runnable {
    Rect player1, player2, ball;
    PlayerController pControl;
    UI ui;

    @Override
    public void run() {
        ui = UI.getInstance();
        ui.initWindow();
        initPlayersAndBall();

        double lastFrameTime = Time.getTime();
        while (true) {
            double now = Time.getTime();
            double deltaTime = now - lastFrameTime;
            lastFrameTime = now;
            update(deltaTime);

            if (ui.keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                System.out.println("DOWN");
            }
            if (ui.keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                System.out.println("UP");
            }

            try {
                Thread.sleep(30);
            } catch (Exception e) {

            }
        }
    }

    public void update(double dt) {
        ui.getGraphics().setColor(Constants.SCREEN_BG);
        ui.getGraphics().fillRect(0, 0, Constants.WINDOW_W, Constants.WINDOW_H);

        pControl.update(dt);

        player1.draw();
        player2.draw();
        ball.draw();
    }

    private void initPlayersAndBall() {
        player1 = new Rect(
                Constants.PADDLE_PADDING,
                Constants.WINDOW_H / 2,
                Constants.PADDLE_W,
                Constants.PADDLE_H
        );
        player2 = new Rect(
                Constants.WINDOW_W - Constants.PADDLE_PADDING - Constants.PADDLE_W,
                Constants.WINDOW_H / 2,
                Constants.PADDLE_W,
                Constants.PADDLE_H
        );
        ball = new Rect(
                Constants.WINDOW_W / 2,
                Constants.WINDOW_H / 2,
                Constants.BALL_SIZE,
                Constants.BALL_SIZE
        );
        pControl = new PlayerController(player1);
    }
}
