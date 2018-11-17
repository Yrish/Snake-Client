package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.UI.Actable;
import me.braysen.goodwin.game.UI.Selectable;
import me.braysen.goodwin.game.UI.Selection;
import me.braysen.goodwin.game.UI.SelectionLabel;
import me.braysen.goodwin.game.managers.KeyManager;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SelectionState extends GameState {
    public static final String ID = "SELECTION";

    public SelectionState() {
        super(ID);
    }

    public void tick(Manager m) {
        m.getEntityManager().tick(m);
        m.getUIManager().tick(m);
    }

    public void render(Graphics g, Manager m) {
        m.getUIManager().render(g,m);
    }

    @Override
    public void init(Manager m) {
        super.init(m);
        Selectable[] selections =  {
                new SelectionLabel("Single Player", new Actable() {
                    @Override
                    public void act() {
                        m.getGameStateManager().setCurrentState(SinglePlayState.ID);
                    }
                }, m),
                new SelectionLabel("Multi Player", new Actable() {
                    @Override
                    public void act() {
                        m.getGameStateManager().setCurrentState(SinglePlayState.ID);
                    }
                }, m)};
        m.getUIManager().add(new Selection(selections));
    }
}
