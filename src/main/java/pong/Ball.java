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
            setBallNewVelocities();
        } else if (checkTopCollision() || checkFloorCollision()) {
            reverseVelocityY();
        }

        updatePosition(dt);
    }

    private void setBallNewVelocities() {
        double newAngle = getNewVelocityAngle();
        double newVx = Math.abs(Math.cos(newAngle));
        double newVy = (-Math.sin(newAngle));

        double oldSign = Math.signum(vx);
        vx = newVx * (-1 * oldSign);
        vy = newVy;
    }

    private double getNewVelocityAngle() {
        double intersectY = leftPaddle.getInWindowCenterY() - getInWindowCenterY();
        double normalizedIntersect = intersectY / (leftPaddle.h / 2);
        double newAngle = normalizedIntersect * Constants.BALL_MAX_ANGLE;
        return Math.toRadians(newAngle);
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

    private boolean checkTopCollision() {
        return isMovingUp() && getTop() <= Constants.INSETS_TOP;
    }

    private boolean checkFloorCollision() {
        return isMovingDown() && getBottom() >= Constants.WINDOW_H;
    }

    private boolean isMovingUp() {
        return vy <= 0;
    }

    private boolean isMovingDown() {
        return vy > 0;
    }

    private void reverseVelocityY() {
        vy *= -1;
    }

    private void updatePosition(double dt) {
        x += vx * Constants.BALL_SPEED * dt;
        y += vy * Constants.BALL_SPEED * dt;
    }
}
