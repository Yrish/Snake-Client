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

    public CollisionGridSnapShot(int xOff, int yOff, int radius, Manager m) {
        Environment env = m.getEnvironmentManager().getEnvironment();
        radius = Math.max(Math.min(Math.min(env.getHeight(), env.getWidth() - 1), radius), 0);
        this.width = radius * 2 + 1;
        grid = new int[width][width];
        this.xOff = xOff;
        this.yOff = yOff;
        envWidth = m.getEnvironmentManager().getWidth();
        envHeight = m.getEnvironmentManager().getHeight();
        for (Entity e: m.getEntityManager().getEntities()) {
            e.drawCollisionMap(this);
        }
    }

    public void drawCollision(int x, int y, int value) {
        int rx = x - (xOff - width / 2);
        int ry = y - (yOff - width / 2);
        if (x < xOff - width  / 2  && xOff + width >= envWidth && x < (xOff + width) % envWidth) {
            rx = x + (envWidth - xOff - width / 2);
        } else if (x > xOff + width / 2 && xOff - width < 0 && x > envWidth + (xOff - width)) {
            rx = width + (x -xOff);
        }
        if (y < yOff - width  / 2  && yOff + width >= envHeight && y < (yOff + width) % envHeight) {
            ry = y + (envHeight - yOff - width / 2);
        } else if (y > yOff + width / 2 && yOff - width < 0 && x > envHeight + (yOff - width)) {
            ry = width + (y -yOff);
        }
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
        if (rx < 0 || ry < 0 || rx >= width - 1 || ry >= width - 1) {
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
