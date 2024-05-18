package pong;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rect {
    protected final double w, h;
    protected double x, y;

    public Rect(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public double getTop() {
        return y;
    }

    public double getBottom() {
        return y + h;
    }

    public double getLeft() {
        return x;
    }

    public double getRight() {
        return x + w;
    }

    public double getInWindowCenterY() {
        return y + h / 2;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(Constants.SCREEN_COLOR);
        g.fill(new Rectangle2D.Double(x, y, w, h));
    }
}
