package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.UI.Selectable;
import me.braysen.goodwin.game.UI.Selection;
import me.braysen.goodwin.game.UI.SelectionLabel;
import me.braysen.goodwin.game.entities.Entity;
import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;
import me.braysen.goodwin.network.NetworkManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.UUID;

public class MultiplayerPlayState extends PlayState {
    public static final String ID = "MULTI_PLAY";
    private boolean isDead;
    private boolean isPaused;
    private Selection deathSelection;
    private Selection pauseSelection;
    private Snake player;

    public MultiplayerPlayState() {
        super(ID);
    }

    public void tick(Manager m) {
        super.tick(m);
        if (m.getKeyManager().isPressed(KeyEvent.VK_ESCAPE) && !isDead) {
            pause();
        }
        if (isPaused){
            pauseSelection.tick(m);
        }
        if (isDead) {
            deathSelection.tick(m);
        }
//        m.getNetworkManager().pushNewSnake(player);
    }

    @Override
    public void render(Graphics g, Manager m) {
        super.render(g, m);
        if (isPaused || isDead) {
            g.setColor(new Color(255,255,255, 150));
            g.fillRect(0,0,m.getDisplay().getWidth(),m.getDisplay().getHeight());
            g.setColor(Color.BLACK);
            if (isPaused) {
                pauseSelection.render(g, m);
            }
            if (isDead) {
                deathSelection.render(g,m);
            }
        }
    }

    public void init(Manager m) {
        super.init(m);
        player = new Snake(0,0, UUID.randomUUID(), new Color((int)(Math.random() * (double)Integer.MAX_VALUE)));
        m.getEntityManager().registerPlayer(player);
        isPaused = false;
        Selectable[] pauseOptions = {
                new SelectionLabel("Resume", () -> resume(), m),
                new SelectionLabel("Return to Menu", () -> m.getGameStateManager().setCurrentState(SelectionState.ID), m),
                new SelectionLabel("Close", () -> System.exit(0), Color.RED, Color.BLACK, m),
        };
        pauseSelection = new Selection(pauseOptions);
        Selectable[] deathOptions = {
                new SelectionLabel("Try again", () -> {m.getGameStateManager().destroyState(ID);m.getGameStateManager().setCurrentState(ID);},m),
                new SelectionLabel("Return to Menu", () -> {m.getGameStateManager().destroyState(ID);m.getGameStateManager().setCurrentState(SelectionState.ID);}, m),
                new SelectionLabel("Close", () -> System.exit(0), Color.RED, Color.BLACK, m),
        };
        deathSelection = new Selection(deathOptions);
        NetworkManager networkManager = new NetworkManager(m.getEntityManager());
        m.setNetworkManager(networkManager);
        networkManager.createConnection();
    }

    @Override
    public void onDeath(Entity killer, Manager m) {
        isDead = true;
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }
}
