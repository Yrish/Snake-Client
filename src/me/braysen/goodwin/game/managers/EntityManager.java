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
}
