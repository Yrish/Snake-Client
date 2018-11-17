package me.braysen.goodwin.game.ai;

import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;

public class AI {

    public void moveSnake(Snake s, Manager m) {
        CollisionGridSnapShot grid = new CollisionGridSnapShot(s.getX(), s.getY(), 10, m);
        int cx = (s.getDirection().ordinal() - 2) * (s.getDirection().ordinal() % 2);
        int cy = (s.getDirection().ordinal() - 1) * ((s.getDirection().ordinal() + 1) % 2);
        s.setDirection(getSugestedDirection(cx, cy, grid));
    }

    public Snake.Direction getSugestedDirection(int cx, int cy, CollisionGridSnapShot sur) {
        int[] forward = sur.getLine(cx,cy);
        if (getDangerCount(forward) > 0) {
            return convertDirection(cy,cx);
        }
        return Snake.Direction.NORTH;
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

    public int getDangerCount(int[] line) {
        int res = 0;
        for (int i: line) {
            if (i < 0) {
                res -= i;
            }
        }
        return res;
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
