package me.braysen.goodwin.game.network;

import me.braysen.goodwin.game.entities.Food;
import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.EntityManager;

public class NetworkEvent {

    private EntityManager entityManager;

    public NetworkEvent(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void removeFood(Food food) {

    }

    public void showFood(Food food) {

    }

    public void updateOtherSnake(Snake otherMovedSnake) {

    }

}
