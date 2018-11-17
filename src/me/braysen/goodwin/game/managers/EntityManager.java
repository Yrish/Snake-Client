package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.entities.Entity;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {


    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void tick(Manager m) {
        for (Entity e: entities) {
            e.tick(m);
        }
    }

    public void render(Graphics g, Manager m) {
        for (Entity e: entities) {
            e.render(g, m);
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
