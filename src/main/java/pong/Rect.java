package pong;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rect {
    private double x, y, w, h;

    public Rect(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        UI ui = UI.getInstance();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(Constants.SCREEN_COLOR);
        g.fill(new Rectangle2D.Double(x, y, w, h));
    }
}
