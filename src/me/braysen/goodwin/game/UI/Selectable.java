package me.braysen.goodwin.game.UI;

import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public interface Selectable {
    void select();
    void deselect();
    void act();
    void render(Graphics g, Manager m, int xBase, int yBase);
    int getWidth();
    int getHeight();
}
