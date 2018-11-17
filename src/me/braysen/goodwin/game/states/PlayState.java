package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.entities.Food;
import me.braysen.goodwin.game.environment.Environment;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.util.UUID;

public class PlayState extends GameState {
    public static final String ID = "PLAY";
    private Environment env = new Environment();

    public PlayState() {
        super(ID);
    }

    public void tick(Manager m) {
        env.updateTileSize(m);
    }

    public void render(Graphics g, Manager m) {
        env.render(g, m);
        m.getEntityManager().render(g,m);
    }

    @Override
    public void init(Manager m) {
//        m.getEntityManager().add(new Food(40,40, new UUID(50,20)));
    }
}
