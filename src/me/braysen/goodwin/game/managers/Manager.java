package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.Display;
import me.braysen.goodwin.game.states.GameState;

public class Manager {
    private GameStateManager gsm;
    private EntityManager em;
    private AssetManager am;
    private Display display;

    public Manager(Display display) {
        gsm = new GameStateManager();
        em = new EntityManager();
        am = new AssetManager();
        this.display = display;
    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public void setGameStateManager(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public AssetManager getAssetManager() {
        return am;
    }

    public void setAssetManager(AssetManager am) {
        this.am = am;
    }

    public Display getDisplay() {
        return display;
    }
}
