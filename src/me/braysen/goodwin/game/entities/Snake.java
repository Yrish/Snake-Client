package me.braysen.goodwin.game.entities;


import me.braysen.goodwin.game.ai.AI;
import me.braysen.goodwin.game.ai.CollisionGridSnapShot;
import me.braysen.goodwin.game.managers.KeyManager;
import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.RenderManager;
import me.braysen.goodwin.game.states.PlayState;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Snake extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Direction direction;
    private ArrayList<Point> trail;
    private Color color;
    private int trailLength;
    private transient AI ai;

    public Snake(int x, int y, UUID uuid, Color color) {
        super(uuid, x, y);
        this.trail = new ArrayList<>();
        this.color = color;
        this.trailLength = 0;
        this.direction = Direction.WEST;
        this.ai = new AI();
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

    public void setTrailLength(int trailLength) {
        this.trailLength = trailLength;
    }

    public enum Direction implements Serializable {
        NORTH,
        WEST,
        SOUTH,
        EAST
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

        int nx = -1, ny = -1;

        if (m.getEntityManager().isPlayer(this)) {
            KeyManager k = m.getKeyManager();
            if (direction != Direction.WEST && (k.isPressed(KeyEvent.VK_RIGHT) || k.isPressed(KeyEvent.VK_D))) {
                direction = Direction.EAST;
            } else if (direction != Direction.EAST && (k.isPressed(KeyEvent.VK_LEFT) || k.isPressed(KeyEvent.VK_A))) {
                direction = Direction.WEST;
            } else if (direction != Direction.SOUTH && (k.isPressed(KeyEvent.VK_UP) || k.isPressed(KeyEvent.VK_W))) {
                direction = Direction.NORTH;
            } else if (direction != Direction.NORTH && (k.isPressed(KeyEvent.VK_DOWN) || k.isPressed(KeyEvent.VK_S))) {
                direction = Direction.SOUTH;
            }
        } else {
            ai.moveSnake(this, m);
        }

        if (direction == Direction.NORTH) {
            nx = x;
            if (y - 1 < 0) {
                ny = m.getEnvironmentManager().getHeight() - 1;
            } else {
                ny = y - 1;
            }
        } else if (direction == Direction.SOUTH) {
            nx = x;
            ny = (y + 1) % m.getEnvironmentManager().getHeight();
        } else if (direction == Direction.WEST) {
            ny = y;
            if (x - 1 < 0) {
                nx = m.getEnvironmentManager().getWidth() - 1;
            } else {
                nx = x - 1;
            }
        } else {
            ny = y;
            nx = (x + 1) % m.getEnvironmentManager().getWidth();
        }

        for (Entity e: m.getEntityManager().getEntitiesAtPoint(nx,ny)) {
            if (e instanceof Food) {
                trailLength++;
                e.kill(this, m);
            } else {
                if (((Snake)e).isOpositeDirection(this.direction)) {
                    if (!m.getEntityManager().isPlayer(this)) {
                        if (!m.getEntityManager().isPlayer(e)) {
                            e.kill(this, m);
                        } else {
                            e.kill(this, m);
                            return;
                        }
                    }
                    this.kill(e, m);
                    return;
                }
                this.kill(e,m);
            }
        }

        trail.add(0, new Point(x,y));

        x = nx;
        y = ny;

        if (trailLength < trail.size()) {
            trail.remove(trail.size() - 1);
        }

    }

    @Override
    public boolean collides(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        }
        for (int i = 1; i < trail.size(); i++) {
            if (trail.get(i).x == x && trail.get(i).y == y) {
                return true;
            }
        }
        return false;
    }

    public boolean headAt(int x, int y) {
        return x == this.x && y == this.y;
    }

    public boolean isOpositeDirection(Direction dir) {
        return (dir.ordinal() - direction.ordinal()) % 2 == 0;
    }

    @Override
    public void drawCollisionMap(CollisionGridSnapShot g) {
        g.drawCollision(x,y,-1);
        for (Point p: trail) {
            g.drawCollision(x,y,-2);
        }
        if (trail.size() > 0) {
            Point last = trail.get(trail.size() - 1);
            g.drawCollision(last.x, last.y, -3);
        }
    }

    @Override
    public void kill(Entity killer, Manager m) {
        CollisionGridSnapShot snap = new CollisionGridSnapShot(x,y,10,m);
        if (m.getEntityManager().isPlayer(this)) {
            ((PlayState) m.getGameStateManager().getCurrentState()).onDeath(killer, m);
            return;
        }
        m.getEntityManager().remove(this);
    }
}
