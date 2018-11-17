package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.Display;
import me.braysen.goodwin.network.NetworkManager;

public class Manager {
    private GameStateManager gsm;
    private EntityManager em;
    private AssetManager am;
    private Display display;
    private KeyManager key;
    private RenderManager rm;
    private UIManager um;
    private EnvironmentManager env;
    private NetworkManager networkManager;

    public Manager(Display display, KeyManager key) {
        gsm = new GameStateManager();
        gsm.init(this);
        em = new EntityManager();
        am = new AssetManager();
        am.init();
        rm = new RenderManager(this);
        this.display = display;
        this.key = key;
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

    public KeyManager getKeyManager() {
        return key;
    }

    public RenderManager getRenderManager() {
        return rm;
    }

    public UIManager getUIManager() {
        return um;
    }

    public void setUIManager(UIManager um) {
        this.um = um;
    }

    public EnvironmentManager getEnvironmentManager() {
        return env;
    }

    public void setEnvironmentManager(EnvironmentManager env) {
        this.env = env;
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }
}
