package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public class SelectionState extends GameState {
    public static final String ID = "SELECTION";

    public SelectionState() {
        super(ID);
    }

    public void tick(Manager m) {

    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(200,200,100,100);
    }
}
