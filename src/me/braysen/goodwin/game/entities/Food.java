package me.braysen.goodwin.game.entities;

import me.braysen.goodwin.game.ai.CollisionGridSnapShot;
import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.RenderManager;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.UUID;

public class Food extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;



    public Food(int x, int y, UUID uuid) {
        super(uuid, x, y);
    }

    @Override
    public void render(Graphics g, Manager m) {
        g.setColor(Color.red);
        RenderManager r = m.getRenderManager();
        g.drawImage(m.getAssetManager().getFoodTextures().get(0), x*m.getRenderManager().getTileWidth(), y*m.getRenderManager().getTileWidth(), m.getRenderManager().getTileWidth(), m.getRenderManager().getTileHeight(), null, null);
    }

    @Override
    public void kill(Entity killer, Manager m) {
        m.getEntityManager().remove(this);
        m.getEntityManager().spawnRandomFood(m);
        m.getEntityManager().spawnRandomFood(m);
        m.getEntityManager().spawnRandomFood(m);
    }

    @Override
    public boolean collides(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public void drawCollisionMap(CollisionGridSnapShot g) {
        g.drawCollision(x,y,1);
    }
}
