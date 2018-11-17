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
        g.drawImage(m.getAssetManager().getFoodTextures().get(0), x*m.getRenderManager().getTileWidth(), y*m.getRenderManager().getTileWidth(), m.getRenderManager().getTileWidth(), m.getRenderManager().getTileHeight(), null, null);
    }

    @Override
    public void kill(Entity killer, Manager m) {
        m.getEntityManager().remove(this);
        m.getEntityManager().spawnRandomFood(m);
        m.getEntityManager().spawnRandomFood(m);
        m.getEntityManager().spawnRandomFood(m);
    }
}
