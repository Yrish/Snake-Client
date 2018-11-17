package me.braysen.goodwin.game.ai;

import me.braysen.goodwin.game.entities.Entity;
import me.braysen.goodwin.game.environment.Environment;
import me.braysen.goodwin.game.managers.Manager;

public class CollisionGridSnapShot {

    private int[][] grid;
    int xOff;
    int yOff;
    int width;

    public CollisionGridSnapShot(int xOff, int yOff, int radius, Manager m) {
        Environment env = m.getEnvironmentManager().getEnvironment();
        radius = Math.max(Math.min(Math.min(env.getHeight(), env.getWidth() - 1), radius), 0);
        this.width = radius * 2 + 1;
        grid = new int[width][width];
        this.xOff = xOff - radius;
        this.yOff = yOff - radius;
        for (Entity e: m.getEntityManager().getEntities()) {
            e.drawCollisionMap(this);
        }
    }

    public void drawCollision(int x, int y, int value) {
        int rx = x - xOff;
        int ry = y - yOff;
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
