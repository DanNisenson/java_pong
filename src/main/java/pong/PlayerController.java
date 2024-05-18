package pong;

public class PlayerController {
    private final Rect paddle;
    private final KL keyListener;
    private final int keyUpCode, keyDownCode;

    public PlayerController(Rect playerPaddle, int keyUpCode, int keyDownCode) {
        this.paddle = playerPaddle;
        keyListener = UI.getInstance().keyListener;
        this.keyUpCode = keyUpCode;
        this.keyDownCode = keyDownCode;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed((keyDownCode))) {
            movePaddle(dt, false);
        } else if (keyListener.isKeyPressed((keyUpCode))) {
            movePaddle(dt, true);
        }
    }

    public void movePaddle(double dt, boolean goingUp) {
        double y = paddle.getY();
        if (goingUp) {
            if (!willMovePastTop(y, dt)) {
                y -= (Constants.PADDLE_SPEED * dt);
            }
        } else {
            if (!willMovePastBottom(y, dt)) {
                y += (Constants.PADDLE_SPEED * dt);
            }
        }
        paddle.setY(y);
    }

    private boolean willMovePastTop(double y, double dt) {
        return y - Constants.PADDLE_SPEED * dt <= Constants.INSETS_TOP;
    }

    private boolean willMovePastBottom(double y, double dt) {
        return y + Constants.PADDLE_H + Constants.PADDLE_SPEED * dt >= Constants.WINDOW_H;
    }
}
