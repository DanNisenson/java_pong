package pong;

public class Ball extends Rect {
    Rect leftPaddle;
    Rect rightPaddle;

    private double vx = -1;
    private double vy = -1;

    public Ball(double x, double y, double w, double h, Rect leftPaddle, Rect rightPaddle) {
        super(x, y, w, h);
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public void update(double dt) {
        if (checkLeftPaddleCollision() || checkRightPaddleCollision()) {
            reverseVelocityX();
            setNewAngleY();
        } else if (checkWindowTopCollision() || checkWindowBottomCollision()) {
            reverseVelocityY();
        }

        updatePosition(dt);
    }

    private boolean checkLeftPaddleCollision() {
        boolean isLeftOfLeftPaddle = getLeft() <= leftPaddle.getRight();
        return isMovingLeft() && isLeftOfLeftPaddle && isWithinPaddleY(leftPaddle);
    }

    private boolean checkRightPaddleCollision() {
        boolean isRightOfRightPaddle = getRight() >= rightPaddle.getLeft();
        return isMovingRight() && isRightOfRightPaddle && isWithinPaddleY(rightPaddle);
    }

    private boolean isMovingLeft() {
        return vx < 0;
    }

    private boolean isMovingRight() {
        return vx >= 0;
    }

    private boolean isWithinPaddleY(Rect paddle) {
        return getBottom() >= paddle.getTop() && getTop() <= paddle.getBottom();
    }

    private boolean checkWindowTopCollision() {
        return isMovingUp() && getTop() <= Constants.INSETS_TOP;
    }

    private boolean checkWindowBottomCollision() {
        return isMovingDown() && getBottom() >= Constants.WINDOW_H;
    }

    private boolean isMovingUp() {
        return vy <= 0;
    }

    private boolean isMovingDown() {
        return vy > 0;
    }

    private void reverseVelocityX() {
        vx *= -1;
    }

    private void reverseVelocityY() {
        vy *= -1;
    }

    private void setNewAngleY() {
        double intersectY = leftPaddle.getInWindowCenterY() - getInWindowCenterY();
        double normalizedIntersect = intersectY / (leftPaddle.h / 2);
        double newAngle = normalizedIntersect * Constants.BALL_MAX_ANGLE;
        double newAngleRads = Math.toRadians(newAngle);
        vy = (-Math.sin(newAngleRads));
    }

    private void updatePosition(double dt) {
        x += vx * Constants.BALL_SPEED * dt;
        y += vy * Constants.BALL_SPEED * dt;
    }
}
