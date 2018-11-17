package me.braysen.goodwin.entities;

import java.awt.Point;
import java.util.ArrayList;

public class Snake extends Entity {

    private Direction direction;
    private ArrayList<Point> trail;

    public Snake(int x, int y, String uuid) {
        super(x, y, uuid);
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
}
