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
}
