package me.braysen.goodwin.game.entities;


import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.RenderManager;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Snake extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Direction direction;
    private ArrayList<Point> trail;
    private Color color;

    public Snake(int x, int y, UUID uuid, Color color) {
        super(uuid, x, y);
        this.trail = new ArrayList<>();
        this.color = color;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ArrayList<Point> getTrail() {
        return trail;
    }

    public void setTrail(ArrayList<Point> trail) {
        this.trail = trail;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public enum Direction implements Serializable {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    @Override
    public void render(Graphics g, Manager m) {
        g.setColor(Color.blue);
        RenderManager r = m.getRenderManager();
        g.fillRect(x*r.getTileWidth(),y*r.getTileHeight(),r.getTileWidth(),r.getTileHeight());
    }
}