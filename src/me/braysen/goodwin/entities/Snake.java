package me.braysen.goodwin.entities;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.UUID;

public class Snake extends Entity {

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

        public static Direction fromDataCode(byte dataCode) {
            for (Direction direction : Direction.values()) {
                if (direction.getDataCode() == dataCode) {
                    return direction;
                }
            }
            return null;
        }
    }
}
