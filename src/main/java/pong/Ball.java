package pong;

public class Ball extends Rect {
    Rect leftPaddle;
    Rect rightPaddle;

    private double vx = 300;
    private double vy = -150;

    public Ball(double x, double y, double w, double h, Rect leftPaddle, Rect rightPaddle) {
        super(x, y, w, h);
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public void update(double dt) {
        if (checkLeftPaddleCollision() || checkRightPaddleCollision()) {
            reverseVelocityX();
        } else if (checkTopCollision() || checkFloorCollision()) {
            reverseVelocityY();
        }
        updatePosition(dt);
    }

    private boolean checkLeftPaddleCollision() {
        boolean isLeftOfLeftPaddle = x <= leftPaddle.x + leftPaddle.w;
        boolean isWithinLeftPaddleY = isWithinPaddleY(leftPaddle);
        return isLeftOfLeftPaddle && isWithinLeftPaddleY;

    }

    private boolean checkRightPaddleCollision() {
        boolean isRightOfRightPaddle = x + w >= rightPaddle.x;
        boolean isWithinRightPaddleY = isWithinPaddleY(rightPaddle);
        return isRightOfRightPaddle && isWithinRightPaddleY;
    }

    private boolean isWithinPaddleY(Rect paddle) {
        return y + h >= paddle.y && y <= paddle.y + paddle.h;
    }

    private void reverseVelocityX() {
        vx *= -1;
    }

    private boolean checkTopCollision() {
        return y <= Constants.INSETS_TOP;
    }

    private boolean checkFloorCollision() {
        return y + h >= Constants.WINDOW_H;
    }

    private void reverseVelocityY() {
        vy *= -1;
    }

    private void updatePosition(double dt) {
        x += vx * dt;
        y += vy * dt;
    }
}
