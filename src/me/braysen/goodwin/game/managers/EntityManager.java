package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.entities.Entity;
import me.braysen.goodwin.game.entities.Food;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class EntityManager {

    private ArrayList<Entity> entities;
    private ArrayList<Entity> removeBuffer = new ArrayList<>();
    private ArrayList<Entity> addBuffer = new ArrayList<>();
    private boolean concurrent;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void tick(Manager m) {
        concurrent = true;
        for (Entity e: entities) {
            e.tick(m);
        }
        concurrent = false;
        postTick(m);
    }

    public void render(Graphics g, Manager m) {
        concurrent = true;
        for (Entity e: entities) {
            e.render(g, m);
        }
        concurrent = false;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void add(Entity e) {
        if (!concurrent) {
            entities.add(e);
            return;
        }
        addBuffer.add(e);
    }

    public void remove(Entity e) {
        if (!concurrent) {
            entities.remove(e);
            return;
        }
        removeBuffer.add(e);
    }

    public void postTick(Manager m) {
        for (Entity e: removeBuffer) {
            entities.remove(e);
        }
        for (Entity e: addBuffer) {
            entities.add(e);
        }
        removeBuffer = new ArrayList<>();
        addBuffer = new ArrayList<>();
    }

    public void spawnRandomFood(Manager m) {
        add(new Food((int) (m.getEnvironmentManager().getWidth() * Math.random()), (int) (m.getEnvironmentManager().getHeight() * Math.random()), new UUID(40,20)));
    }
}
