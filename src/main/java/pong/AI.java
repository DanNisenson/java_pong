package pong;

public class AI extends PlayerController {
    private final Ball ball;

    public AI(Rect paddle, Ball ball) {
        super(paddle);
        this.ball = ball;
    }

    public void update(double dt) {
        if (ball.getBottom() < getPaddle().getTop()) {
            movePaddle(dt, true);
        } else if (ball.getTop() > getPaddle().getBottom()) {
            movePaddle(dt, false);
        }
    }
}
