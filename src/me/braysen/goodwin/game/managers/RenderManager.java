package me.braysen.goodwin.game.managers;

public class RenderManager {

    private Manager m;
    private int tileHeight, tileWidth;


    public void updateTileScale(int width, int height, int tileCountWidth, int tileCountHieght) {
        tileWidth = width/tileCountWidth;
        tileHeight = height/tileCountHieght;
    }

    public RenderManager(Manager manager) {
        m = manager;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }
}
