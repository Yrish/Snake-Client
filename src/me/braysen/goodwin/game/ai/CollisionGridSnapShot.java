package me.braysen.goodwin.game.ai;

import me.braysen.goodwin.game.entities.Entity;
import me.braysen.goodwin.game.environment.Environment;
import me.braysen.goodwin.game.managers.Manager;

public class CollisionGridSnapShot {

    private int[][] grid;
    int xOff;
    int yOff;
    int width;
    int envWidth;
    int envHeight;
    int radius;

    public CollisionGridSnapShot(int xOff, int yOff, int radius, Manager m) {
        Environment env = m.getEnvironmentManager().getEnvironment();
        radius = Math.max(Math.min(Math.min(env.getHeight(), env.getWidth() - 1), radius), 0);
        this.width = radius * 2 + 1;
        grid = new int[width][width];
        this.xOff = xOff;
        this.yOff = yOff;
        this.radius = radius;
        envWidth = m.getEnvironmentManager().getWidth();
        envHeight = m.getEnvironmentManager().getHeight();
        for (Entity e: m.getEntityManager().getEntities()) {
            e.drawCollisionMap(this);
        }
    }

    public void drawCollision(int x, int y, int value) {
        int rx = x - (xOff - radius);
        int ry = y - (yOff - radius);
        if (x < xOff - radius  && xOff + radius >= envWidth && x < (xOff + radius) % envWidth) {
            rx = x + (envWidth -(xOff - radius));
        } else if (x > xOff + radius && xOff - radius < 0 && x > envWidth + (xOff - radius)) {
            rx = radius - (x - envWidth);
        }
        if (y < yOff - radius  && yOff + radius >= envHeight && y < (yOff + radius) % envHeight) {
            ry = y + (envHeight -(yOff - radius));
        } else if (y > yOff + radius && yOff - radius < 0 && x > envHeight + (yOff - radius)) {
            ry = radius - (y - envHeight);
        }
//        if (y < yOff - width  / 2  && yOff + width >= envHeight && y < (yOff + width) % envHeight) {
//            ry = y + (envHeight - yOff - width / 2);
//        } else if (y > yOff + width / 2 && yOff - width < 0 && x > envHeight + (yOff - width)) {
//            ry = width + (y -yOff);
//        }
//        int rx = x - (xOff + width / 2 + 1);
//        int ry = y - (yOff + width / 2 + 1);
//        if (x < xOff - width && (xOff + width) % envWidth > x) {
//            rx = (envWidth - xOff) + x;
//        } else if (rx < 0) {
//            if (rx >=  xOff - width) {
//                rx = width + rx;
//            }
//        }
//        if (y < xOff - width &&(yOff + width) % envHeight > y) {
//            ry = (envWidth - yOff) + y;
//        } else if (ry < 0) {
//            if (ry >=  yOff - width) {
//                ry = width + ry;
//            }
//        }
        if (rx < 0 || ry < 0 || rx >= width || ry >= width) {
            return;
        }
        grid[ry][rx] = value;
    }

    public int[] getLine(int xStep, int yStep, int xStart, int yStart, int length) {
        if (yStep == 0 && xStep == 0) {
            return new int[1];
        } else if (yStep != 0 && xStep == 0) {
            length = Math.min(length, Math.abs((width - yStart)/yStep));
        } else if (yStep == 0 && xStep != 0) {
            length = Math.min(length, Math.abs((width - xStart) / xStep));
        } else {
            length = Math.min(length, Math.min(Math.abs((width - xStart) / xStep), Math.abs((width - yStart)/yStep)));
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = grid[yStart + yStep*i][xStart + xStep*i];
        }
        return res;
    }

    public int[] getLine(int xStep, int yStep) {
        return getLine(xStep, yStep, width / 2, width / 2, width / 2);
    }
}
