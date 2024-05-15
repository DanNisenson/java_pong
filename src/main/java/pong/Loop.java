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
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }

    public void update(double dt) {
        ui.createDbImage();
        Graphics2D dbg = (Graphics2D) ui.getDbGraphics();

        pControl.update(dt);

        ui.setBackground(dbg);
        player1.draw(dbg);
        player2.draw(dbg);
        ball.draw(dbg);

        ui.drawImg();
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
