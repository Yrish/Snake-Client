package me.braysen.goodwin.game.environment;

import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public class Environment {

    int[][] grid;

    public Environment(int width, int height) {
        grid = new int[height][width];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                grid[y][x] = 1;
            }
        }
    }

    public Environment() {
        this(128,128);
    }

    public void render(Graphics g, Manager m) {
        g.setColor(Color.GREEN);
        g.fillRect(0,0, m.getDisplay().getWidth(), m.getDisplay().getHeight());
    }

    public void updateTileSize(Manager m) {
        m.getRenderManager().updateTileScale(m.getDisplay().getWidth(),m.getDisplay().getHeight(),grid[0].length, grid.length);
    }
}
