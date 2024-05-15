package pong;

import java.awt.Graphics;

public class Rect {
    int x, y, w, h;
    Graphics g;

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        UI ui = UI.getInstance();
        g = ui.getGraphics();
    }

    public void draw() {
        g.setColor(Constants.SCREEN_COLOR);
        g.fillRect(x, y, w, h);
    }
}
