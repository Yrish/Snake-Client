package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.entities.Entity;

import java.util.ArrayList;

public class EntityManager {
    protected ArrayList<Entity> entities = new ArrayList<>();

    public EntityManager() {

    }

    public void add(Entity e) {
        if (entities.size() == 0) {
            entities.add(e);
        }
        int max = entities.size();
        int min = 0;
        while (true) {
            int cur = (max + min) / 2;
            int val = e.compareTo(entities.get(cur));
            if (val == 0) {
                entities.set(cur, e);
                return;
            } else if (val > 0) {
                max = cur - 1;
            } else {
                min = cur + 1;
            }
            if (min >= max) {
                entities.set((min+max)/2, e);
            }
        }
    }
}
