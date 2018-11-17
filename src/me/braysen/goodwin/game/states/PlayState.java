package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.entities.Food;
import me.braysen.goodwin.game.environment.Environment;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.util.UUID;

public abstract class PlayState extends GameState {

    public PlayState(String ID) {
        super(ID);
    }

    public void tick(Manager m) {
        m.getEnvironmentManager().getEnvironment().updateTileSize(m);
    }

    public void render(Graphics g, Manager m) {
        m.getEnvironmentManager().getEnvironment().render(g, m);
        m.getEntityManager().render(g,m);
        m.getUIManager().render(g,m);
    }

    @Override
    public void init(Manager m) {
        super.init(m);
        m.getEnvironmentManager().setEnvironment(new Environment());
        m.getEntityManager().add(new Food(40,40, new UUID(50,20)));
    }
}
