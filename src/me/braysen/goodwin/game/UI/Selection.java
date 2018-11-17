package me.braysen.goodwin.game.UI;

import me.braysen.goodwin.game.managers.KeyManager;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Selection extends UI {

    private Selectable[] options;
    private int selected;
    private int height;
    private int width;

    public Selection(Selectable[] options) {
        this.options = options;
        selected = 0;
        int height = 0;
        int width = 0;
        for (Selectable s: options) {
            height += s.getHeight();
            width = Math.max(s.getWidth(), width);
        }
        this.height = height;
        this.width = width;
        if (options.length > 0) {
            options[selected].select();
        }
    }

    @Override
    public void render(Graphics g, Manager m) {
        int xOff = (m.getDisplay().getWidth() - width) / 2;
        int yOff = (m.getDisplay().getHeight() - height) / 2;
        for (Selectable s: options) {
            s.render(g, m, xOff, yOff);
            yOff += s.getHeight();
        }
    }

    @Override
    public void tick(Manager m) {
        KeyManager k = m.getKeyManager();
        if (k.justPressed(KeyEvent.VK_UP) || k.justPressed(KeyEvent.VK_W)) {
            options[selected].deselect();
            if (selected - 1 < 0) {
                selected = options.length - 1;
            } else {
                selected -= 1;
            }
            options[selected].select();
        }
        if (k.justPressed(KeyEvent.VK_DOWN) || k.justPressed(KeyEvent.VK_S)) {
            options[selected].deselect();
            selected = (selected + 1) % options.length;
            options[selected].select();
        }
        if (k.justPressed(KeyEvent.VK_ENTER) || k.justPressed(KeyEvent.VK_RIGHT) || k.justPressed(KeyEvent.VK_D) || k.justPressed(KeyEvent.VK_SPACE)) {
            options[selected].act();
        }
    }
}
