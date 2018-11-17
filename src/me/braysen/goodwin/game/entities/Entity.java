package me.braysen.goodwin.game.entities;

import me.braysen.goodwin.game.ai.CollisionGridSnapShot;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.UUID;

public abstract class Entity implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;

    protected int x, y;
    protected UUID uuid;

    public Entity(UUID uuid, int x, int y) {
        this.x = x;
        this.y = y;
        this.uuid = uuid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void drawCollisionMap(CollisionGridSnapShot g);

    public int compareTo(Object other) {
        if (!(other instanceof Entity)) {
            return -1;
        }
        return this.uuid.compareTo(((Entity) other).uuid);
    }

    public UUID getUUID() {
        return uuid;
    }

    public void render(Graphics g, Manager m) {

    }

    public void tick(Manager m) {}

    public void kill(Entity killer, Manager m){}

    public abstract boolean collides(int x, int y);
}
