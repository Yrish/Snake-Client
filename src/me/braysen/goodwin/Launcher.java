package me.braysen.goodwin;

public class Launcher {
    public static void main(String[] args) {
        Game g = new Game(1280, 820);
        g.init();
        g.start();
    }
}
