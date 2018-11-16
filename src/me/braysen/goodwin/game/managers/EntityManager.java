package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.entities.Food;
import me.braysen.goodwin.entities.Snake;

import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Snake> snakes;
    private ArrayList<Food> foods;

    public EntityManager() {
        this.snakes = new ArrayList<>();
        this.foods = new ArrayList<>();
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(ArrayList<Snake> snakes) {
        this.snakes = snakes;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
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
