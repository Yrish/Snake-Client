package me.braysen.goodwin.entities;

public abstract class Entity implements Comparable {
    protected int x, y;
    protected String uuid;

    public Entity(int x, int y, String uuid) {
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

    public String getUuid() {
        return uuid;
    }
}
