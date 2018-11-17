package me.braysen.goodwin.game.UI;

import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public class Selection extends UI {

    private Selectable[] options;
    private int selected;

    public Selection(Selectable[] options) {
        this.options = options;
        selected = 0;
    }

    @Override
    public void render(Graphics g, Manager m) {

    }

    @Override
    public void tick(Manager m) {

    }
}
