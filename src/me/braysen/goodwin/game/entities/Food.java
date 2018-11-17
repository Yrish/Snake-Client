package me.braysen.goodwin.game.entities;

import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.RenderManager;

import java.awt.*;
import java.util.UUID;

public class Food extends Entity {

    public Food(int x, int y, UUID uuid) {
        super(uuid, x, y);
    }

    @Override
    public void render(Graphics g, Manager m) {
        g.setColor(Color.red);
        RenderManager r = m.getRenderManager();
        g.fillOval(x*r.getTileWidth(),y*r.getTileHeight(),r.getTileWidth(),r.getTileHeight());
    }
}
