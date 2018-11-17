package me.braysen.goodwin;

import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.states.SelectionState;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game {

    protected Display display;
    private Manager manager;

    public Game(int width, int height) {
        display = new Display("Snake Game", width, height);
    }

    public void init() {
        manager = new Manager(display);
        manager.getGameStateManager().setCurrentState(SelectionState.ID);
    }

    public void start() {
        while (true) {

            tick();
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

        manager.getGameStateManager().getCurrentState().startRenderChain(g, manager);

        bs.show();
        g.dispose();
    }

    public void tick() {
        manager.getGameStateManager().getCurrentState().tick(manager);
    }
}
