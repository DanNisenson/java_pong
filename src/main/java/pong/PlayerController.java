package pong;

public class PlayerController {
    private final Rect paddle;
    private final KL keyListener;
    private int keyUpCode;
    private int keyDownCode;

    public PlayerController(Rect playerPaddle, int keyUpCode, int keyDownCode) {
        this.paddle = playerPaddle;
        keyListener = UI.getInstance().keyListener;
        this.keyUpCode = keyUpCode;
        this.keyDownCode = keyDownCode;
    }

    public PlayerController(Rect playerPaddle) {
        this.paddle = playerPaddle;
        keyListener = UI.getInstance().keyListener;
    }

    public Rect getPaddle() {
        return paddle;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed((keyDownCode))) {
            movePaddle(dt, false);
        } else if (keyListener.isKeyPressed((keyUpCode))) {
            movePaddle(dt, true);
        }
    }

    public void movePaddle(double dt, boolean goingUp) {
        double y = paddle.getTop();
        if (goingUp) {
            if (!willMovePastTop(dt)) {
                y -= (Constants.PADDLE_SPEED * dt);
            }
        } else {
            if (!willMovePastBottom(dt)) {
                y += (Constants.PADDLE_SPEED * dt);
            }
        }
        paddle.setY(y);
    }

    private boolean willMovePastTop(double dt) {
        return paddle.getTop() - Constants.PADDLE_SPEED * dt <= Constants.INSETS_TOP;
    }

    private boolean willMovePastBottom(double dt) {
        return paddle.getBottom() + Constants.PADDLE_SPEED * dt >= Constants.WINDOW_H;
    }
}
