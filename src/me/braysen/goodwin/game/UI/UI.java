package me.braysen.goodwin.game.UI;

import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public abstract class UI {
    public abstract void render(Graphics g, Manager m);
    public abstract void tick(Manager m);
}
