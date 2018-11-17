package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.environment.Environment;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public class PlayState extends GameState {
    public static final String ID = "PLAY";
    private Environment env = new Environment();

    public PlayState() {
        super(ID);
    }

    public void tick(Manager m) {

    }

    public void render(Graphics g, Manager m) {
        env.render(g, m);
        g.setColor(Color.RED);
        g.drawRect(500,500,100,100);
    }
}
