package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.UI.Selectable;
import me.braysen.goodwin.game.UI.Selection;
import me.braysen.goodwin.game.UI.SelectionLabel;
import me.braysen.goodwin.game.entities.Entity;
import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.UUID;

public class SinglePlayState extends PlayState {
    public static final String ID = "SINGLE_PLAY";
    private Snake player;
    private boolean isPaused;
    private boolean isDead;
    private Selection pauseSelection;
    private Selection deathSelection;

    public SinglePlayState() {
        super(ID);
    }

    public void init(Manager m) {
        super.init(m);
        player = new Snake(0,0, new UUID(40,20), new Color(100,200,100));
        m.getEntityManager().add(player);
        m.getEntityManager().registerPlayer(player);
//        Snake oponenter = new Snake(0,50, new UUID(50,20), new Color(100,200,100));
//        oponenter.setTrailLength(156);
//        m.getEntityManager().add(oponenter);
//        Snake oponent = new Snake(60,50, new UUID(50,20), new Color(100,200,100));
//        oponent.setTrailLength(200);
//        m.getEntityManager().add(oponent);
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
        for (int i = 0; i < 50; i++) {
            m.getEntityManager().spawnRandomFood(m);
        }
    }

    public void tick(Manager m) {
        super.tick(m);
        if (m.getKeyManager().isPressed(KeyEvent.VK_ESCAPE) && !isDead) {
            pause();
        }
        if (!isPaused && !isDead) {
            m.getEntityManager().tick(m);
        }
        if (isPaused){
            pauseSelection.tick(m);
        }
        if (isDead) {
            deathSelection.tick(m);
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    public void onDeath(Entity killer, Manager m) {
        m.getKeyManager().dropJustPressed();
        isPaused = false;
        isDead = true;
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
}
