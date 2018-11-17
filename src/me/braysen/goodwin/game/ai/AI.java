package me.braysen.goodwin.game.ai;

import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;

public class AI {



    public void moveSnake(Snake s, Manager m) {
        CollisionGridSnapShot grid = new CollisionGridSnapShot(s.getX(), s.getY(), 10, m);
    }
}
