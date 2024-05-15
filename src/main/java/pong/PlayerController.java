package pong;

import java.awt.event.KeyEvent;

public class PlayerController {
    private final Rect rectangle;
    private final KL keyListener;

    public PlayerController(Rect rectangle) {
        this.rectangle = rectangle;
        keyListener = UI.getInstance().keyListener;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed((KeyEvent.VK_DOWN))) {
            if (rectangle.getY() + Constants.PADDLE_H + Constants.PADDLE_SPEED * dt < Constants.WINDOW_H) {
                double newY = rectangle.getY() + (Constants.PADDLE_SPEED * dt);
                rectangle.setY(newY);
            }
        } else if (keyListener.isKeyPressed((KeyEvent.VK_UP))) {
            if (rectangle.getY() - Constants.PADDLE_SPEED * dt > Constants.INSETS_TOP) {
                double newY = rectangle.getY() - (Constants.PADDLE_SPEED * dt);
                rectangle.setY(newY);
            }
        }
    }
}
