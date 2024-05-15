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
            double newY = rectangle.getY() + (100 * dt);
            rectangle.setY(newY);
        } else if (keyListener.isKeyPressed((KeyEvent.VK_UP))) {
            double newY = rectangle.getY() - (100 * dt);
            rectangle.setY(newY);
        }
    }
}
