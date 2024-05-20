package pong;

import java.awt.*;

public class NumberSprites {
    private final int smallSide = 5;
    private final int largeSide = 25;
    private final int spriteH = largeSide * 2 + smallSide * 3;
    private final int spriteW = largeSide + smallSide * 2;

    private final int[] top = {smallSide, 0, largeSide, smallSide};
    private final int[] center = {smallSide, smallSide + largeSide, largeSide, smallSide};
    private final int[] topLeft = {0, smallSide, smallSide, largeSide};
    private final int[] bottomLeft = {0, smallSide * 2 + largeSide, smallSide, largeSide};
    private final int[] bottom = {smallSide, spriteH - smallSide, largeSide, smallSide};
    private final int[] topRight = {spriteW - smallSide, smallSide, smallSide, largeSide};
    private final int[] bottomRight = {spriteW - smallSide, smallSide * 2 + largeSide, smallSide, largeSide};

    private final int[][] zero = {top, topRight, bottomRight, bottom, bottomLeft, topLeft};
    private final int[][] one = {topRight, bottomRight};
    private final int[][] two = {top, topRight, center, bottomLeft, bottom};
    private final int[][] three = {top, topRight, center, bottomRight, bottom};
    private final int[][] four = {topLeft, topRight, center, bottomRight};
    private final int[][] five = {top, topLeft, center, bottomRight, bottom};
    private final int[][] six = {top, topLeft, center, bottomRight, bottom, bottomLeft};
    private final int[][] seven = {top, topRight, bottomRight};
    private final int[][] eight = {top, topRight, topLeft, center, bottomRight, bottomLeft, bottom};
    private final int[][] nine = {top, topRight, topLeft, center, bottomRight};

    private final int[][][] allSprites = {zero, one, two, three, four, five, six, seven, eight, nine};

    private Rect getRect(int[] side, double offsetX, double offsetY) {
        return new Rect(offsetX + side[0], offsetY + side[1], side[2], side[3]);
    }

    public void drawRect(int num, double offsetX, double offsetY, Graphics2D g) {
        int[][] sprite = allSprites[num];
        for (int[] side : sprite) {
            getRect(side, offsetX, offsetY).draw(g);
        }
    }
}
