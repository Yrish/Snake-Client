package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.UI.Actable;
import me.braysen.goodwin.game.UI.Selectable;
import me.braysen.goodwin.game.UI.Selection;
import me.braysen.goodwin.game.UI.SelectionLabel;
import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.UUID;

public class SinglePlayState extends PlayState {
    public static final String ID = "SINGLE_PLAY";
    private Snake player;
    private boolean isPaused;
    private Selection pauseSelection;

    public SinglePlayState() {
        super(ID);
    }

    public void init(Manager m) {
        super.init(m);
        player = new Snake(0,0, new UUID(40,20), new Color(100,200,100));
        m.getEntityManager().add(player);
        isPaused = false;
        Selectable[] options = {
                new SelectionLabel("Resume", () -> resume(), m),
                new SelectionLabel("Return to Menu", () -> m.getGameStateManager().setCurrentState(SelectionState.ID), m),
                new SelectionLabel("Close", () -> System.exit(0), Color.RED, Color.BLACK, m),
        };
        pauseSelection = new Selection(options);
    }

    public void tick(Manager m) {
        super.tick(m);
        if (m.getKeyManager().isPressed(KeyEvent.VK_ESCAPE)) {
            pause();
        }
        if (!isPaused) {
            m.getEntityManager().tick(m);
        } else {
            pauseSelection.tick(m);
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        System.out.println("resumed");
        isPaused = false;
    }

    @Override
    public void render(Graphics g, Manager m) {
        super.render(g, m);
        if (isPaused) {
            g.setColor(new Color(255,255,255, 150));
            g.fillRect(0,0,m.getDisplay().getWidth(),m.getDisplay().getHeight());
            g.setColor(Color.BLACK);
            pauseSelection.render(g,m);
        }
    }
}
