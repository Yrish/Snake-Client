package me.braysen.goodwin.game.entities;


import me.braysen.goodwin.game.managers.KeyManager;
import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.RenderManager;
import me.braysen.goodwin.game.states.PlayState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;
import java.util.UUID;

public class Snake extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Direction direction;
    private ArrayList<Point> trail;
    private Color color;
    private int trailLength;

    public Snake(int x, int y, UUID uuid, Color color) {
        super(uuid, x, y);
        this.trail = new ArrayList<>();
        this.color = color;
        this.trailLength = 0;
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
        for (Point p: trail) {
            g.fillRect(p.x*r.getTileWidth(),p.y*r.getTileHeight(),r.getTileWidth(),r.getTileHeight());
        }
    }

    public void tick(Manager m) {

        trail.add(0, new Point(x,y));

        KeyManager k = m.getKeyManager();
        if (k.isPressed(KeyEvent.VK_A) || k.isPressed(KeyEvent.VK_LEFT)) {
            direction = Direction.EAST;
        } else if (k.isPressed(KeyEvent.VK_RIGHT) || k.isPressed(KeyEvent.VK_D)) {
            direction = Direction.WEST;
        } else if (k.isPressed(KeyEvent.VK_UP) || k.isPressed(KeyEvent.VK_W)) {
            direction = Direction.NORTH;
        } else if (k.isPressed(KeyEvent.VK_DOWN) || k.isPressed(KeyEvent.VK_S)) {
            direction = Direction.SOUTH;
        }

        if (direction == Direction.NORTH) {
            if (y - 1 < 0) {
                y = m.getEnvironmentManager().getHeight() - 1;
            } else {
                y -= 1;
            }
        } else if (direction == Direction.SOUTH) {
            y = (y + 1) % m.getEnvironmentManager().getHeight();
        } else if (direction == Direction.EAST) {
            if (x - 1 < 0) {
                x = m.getEnvironmentManager().getWidth() - 1;
            } else {
                x -= 1;
            }
        } else {
            x = (x + 1) % m.getEnvironmentManager().getWidth();
        }

        for (Entity e: m.getEntityManager().getEntities()) {
            if (e.x == x && e.y ==y && e instanceof Food) {
                trailLength++;
                e.kill(this, m);
            }
        }

        if (trailLength < trail.size()) {
            trail.remove(trail.size() - 1);
        }

        for (Point p: trail) {
            if (p.x == x && p.y ==y) {
                ((PlayState) m.getGameStateManager().getCurrentState()).onDeath(m);
            }
        }

    }
}
