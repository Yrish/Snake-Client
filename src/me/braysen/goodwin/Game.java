package me.braysen.goodwin;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game {

    protected  Display display;

    public Game(int width, int height) {
        display = new Display("Snake Game", width, height);
    }

    public void init() {

    }

    public void start() {
        while (true) {

            render();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void render() {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.clearRect(0,0, display.getWidth(), display.getHeight());

        g.setColor(Color.BLUE);
        g.drawRect(200,200,100,100);

        bs.show();
        g.dispose();
    }
}
