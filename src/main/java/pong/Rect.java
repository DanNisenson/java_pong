package pong;

import java.awt.Graphics;

public class Rect {
    Graphics g;
    private int x, y, w, h;

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        UI ui = UI.getInstance();
        g = ui.getGraphics();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw() {
        g.setColor(Constants.SCREEN_COLOR);
        g.fillRect(x, y, w, h);
    }
}
