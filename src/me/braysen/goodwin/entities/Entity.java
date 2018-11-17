package me.braysen.goodwin.entities;

import java.util.UUID;

public abstract class Entity implements Comparable {
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

    public int compareTo(Object other) {
        if (!(other instanceof Entity)) {
            return -1;
        }
        return this.uuid.compareTo(((Entity) other).uuid);
    }

    public UUID getUUID() {
        return uuid;
    }
}
