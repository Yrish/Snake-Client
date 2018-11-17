package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.managers.KeyManager;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SelectionState extends GameState {
    public static final String ID = "SELECTION";

    public SelectionState() {
        super(ID);
    }

    public void tick(Manager m) {
        KeyManager k = m.getKeyManager();
        if (k.isPressed(KeyEvent.VK_W)) {
            System.out.println("was pressed");
            m.getGameStateManager().setCurrentState(PlayState.ID);
        }
    }

    public void render(Graphics g, Manager m) {
        g.setColor(Color.BLUE);
        g.fillRect(200,200,100,100);
    }
}
