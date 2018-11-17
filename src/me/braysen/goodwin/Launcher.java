package me.braysen.goodwin;

public class Launcher {
    public static void main(String[] args) {
        Game g = new Game(768, 768);
        g.init();
        g.start();
    }
}
