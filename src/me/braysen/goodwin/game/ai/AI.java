package me.braysen.goodwin.game.ai;

import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;

public class AI {

    public void moveSnake(Snake s, Manager m) {
        CollisionGridSnapShot grid = new CollisionGridSnapShot(s.getX(), s.getY(), 30, m);
        int cx = 0;
        int cy = 0;
        if (s.getDirection() == Snake.Direction.EAST) {
            cx = 1;
        } else if (s.getDirection() == Snake.Direction.WEST) {
            cx = -1;
        } else if (s.getDirection() == Snake.Direction.NORTH) {
            cy = -1;
        } else {
            cy = 1;
        }
        Snake.Direction q = s.getDirection();
        Snake.Direction suggested = getSugestedDirection(cx, cy, grid);
        s.setDirection(suggested);
    }

    public Snake.Direction getSugestedDirection(int cx, int cy, CollisionGridSnapShot sur) {
        int[] forward = sur.getLine(cx,cy);
        int[] left = sur.getLine(cx, cy);
        Snake.Direction res;
        if (getDangerCount(forward,-3) > 0) {
            Snake.Direction d = convertDirection(cy,cx);
            res = d;
            return res;
        }
        if (getIncentiveCount(sur.getLine()))
        return convertDirection(cx, cy);
    }

    public Snake.Direction convertDirection(int cx, int cy) {
        if (cy < 0) {
            return Snake.Direction.NORTH;
        }
        if (cy > 0) {
            return Snake.Direction.SOUTH;
        }
        if (cx < 0) {
            return Snake.Direction.WEST;
        }
        return Snake.Direction.EAST;
    }

    public int getDangerCount(int[] line, int base) {
        int res = base;
        for (int i: line) {
            if (i < 0) {
                res -= i;
            }
        }
        return res;
    }

    public int getDangerCount(int[] line) {
        return getDangerCount(line, 0);
    }

    public int getIncentiveCount(int[] line) {
        int res = 0;
        for (int i: line) {
            if (i > 0) {
                res += i;
            }
        }
        return res;
    }
}
