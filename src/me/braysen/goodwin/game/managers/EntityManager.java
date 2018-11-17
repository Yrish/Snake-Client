package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.entities.Entity;
import me.braysen.goodwin.entities.Food;
import me.braysen.goodwin.entities.Snake;

import java.util.ArrayList;

public class EntityManager {


    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
