package pong;

import java.awt.event.KeyEvent;

public class Loop implements Runnable {
    @Override
    public void run() {
        UI ui = UI.getInstance();
        ui.init();

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
        Rect player1 = new Rect(
                Constants.PADDLE_PADDING,
                0,
                Constants.PADDLE_W,
                Constants.PADDLE_H
        );
        Rect player2 = new Rect(
                Constants.WINDOW_W - Constants.PADDLE_PADDING - Constants.PADDLE_W,
                0,
                Constants.PADDLE_W,
                Constants.PADDLE_H
        );
        Rect ball = new Rect(
                Constants.WINDOW_W / 2,
                Constants.WINDOW_H / 2,
                Constants.BALL_SIZE,
                Constants.BALL_SIZE
        );

        player1.draw();
        player2.draw();
        ball.draw();
    }
}
