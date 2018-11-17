package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.loaders.ImageLoader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AssetManager {
    private ArrayList<BufferedImage> environmentTextures = new ArrayList<>();
    private ArrayList<BufferedImage> foodTextures = new ArrayList<>();

    public void init() {
        environmentTextures.add(ImageLoader.loadImage("GRASS"));
        environmentTextures.add(ImageLoader.loadImage("FLOWERS"));

        foodTextures.add(ImageLoader.loadImage("APPLE"));
    }

    public ArrayList<BufferedImage> getEnvironmentTextures() {
        return environmentTextures;
    }

    public ArrayList<BufferedImage> getFoodTextures() {
        return foodTextures;
    }
}
