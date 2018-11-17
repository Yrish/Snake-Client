package me.braysen.goodwin.game.entities;

import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.RenderManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class Snake extends Entity {

    private Direction direction;
    private ArrayList<Point> trail;

    public Snake(int x, int y, UUID uuid) {
        super(uuid, x, y);
        this.trail = new ArrayList<>();
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

    public enum Direction {
        NORTH((byte) 0),
        SOUTH((byte) 1),
        EAST((byte) 2),
        WEST((byte) 3);

        private byte dataCode;

        Direction(byte dataCode) {
            this.dataCode = dataCode;
        }

        public byte getDataCode() {
            return dataCode;
        }
    }

    @Override
    public void render(Graphics g, Manager m) {
        g.setColor(Color.blue);
        RenderManager r = m.getRenderManager();
        g.fillRect(x*r.getTileWidth(),y*r.getTileHeight(),r.getTileWidth(),r.getTileHeight());
    }
}
