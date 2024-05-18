package pong;

public class Ball extends Rect {
    Rect leftPaddle;
    Rect rightPaddle;

    private double vx = -210;
    private double vy = -175;

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
        boolean isLeftOfLeftPaddle = getLeft() <= leftPaddle.getRight();
        boolean isWithinLeftPaddleY = isWithinPaddleY(leftPaddle);
        return isLeftOfLeftPaddle && isWithinLeftPaddleY;

    }

    private boolean checkRightPaddleCollision() {
        boolean isRightOfRightPaddle = getRight() >= rightPaddle.getLeft();
        boolean isWithinRightPaddleY = isWithinPaddleY(rightPaddle);
        return isRightOfRightPaddle && isWithinRightPaddleY;
    }

    private boolean isWithinPaddleY(Rect paddle) {
        return getBottom() >= paddle.getTop() && getTop() <= paddle.getBottom();
    }

    private void reverseVelocityX() {
        vx *= -1;
    }

    private boolean checkTopCollision() {
        return getTop() <= Constants.INSETS_TOP;
    }

    private boolean checkFloorCollision() {
        return getBottom() >= Constants.WINDOW_H;
    }

    private void reverseVelocityY() {
        vy *= -1;
    }

    private void updatePosition(double dt) {
        x += vx * dt;
        y += vy * dt;
    }
}
