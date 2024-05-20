package pong;

public class Ball extends Rect {
    GameState state;
    Rect leftPaddle;
    Rect rightPaddle;

    private double vx = -1;
    private double vy = -1;

    public Ball(double w, double h, Rect leftPaddle, Rect rightPaddle) {
        super(0, 0, w, h);
        resetBall();
        state = GameState.getInstance();
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

        if (x <= 0) {
            state.upP2Score();
            resetBall();
        } else if (x >= Constants.WINDOW_W) {
            state.upP1Score();
            resetBall();
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

    private void resetBall() {
        double ballCenter = w / 2;
        x = (double) Constants.WINDOW_W / 2 - ballCenter;
        y = (double) Constants.WINDOW_H / 2 - ballCenter;
        randomizeDirection();
    }

    private void randomizeDirection() {
        double randomX = Math.random() < 0.5 ? 1 : -1;
        double randomY = Math.random() < 0.5 ? 1 : -1;
        vx = randomX;
        vy = randomY;
    }
}
