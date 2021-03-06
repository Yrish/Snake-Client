package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.managers.EntityManager;
import me.braysen.goodwin.game.managers.EnvironmentManager;
import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.game.managers.UIManager;

import java.awt.*;

public abstract class GameState {

    protected String id;

    public GameState(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void startRenderChain(Graphics g, Manager m) {
        preRender(g, m);
        render(g, m);
    }

    public void preRender(Graphics g, Manager m) {
        g.clearRect(0,0, m.getDisplay().getWidth(), m.getDisplay().getHeight());
        g.setColor(Color.BLACK);
    }

    public abstract void render(Graphics g, Manager m);

    public abstract void tick(Manager m);

    public void init(Manager m) {
        m.setUIManager(new UIManager());
        m.setEntityManager(new EntityManager());
        m.setEnvironmentManager(new EnvironmentManager());
    }
}
