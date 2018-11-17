package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.UI.UI;

import java.awt.*;
import java.util.ArrayList;

public class UIManager {
    protected ArrayList<UI> uis;

    public UIManager() {
        uis = new ArrayList<>();
    }

    public void add(UI u) {
        uis.add(u);
    }

    public void tick(Manager m) {
        for (UI u: uis) {
            u.tick(m);
        }
    }

    public void render(Graphics g, Manager m) {
        for (UI u: uis) {
            u.render(g, m);
        }
    }
}
