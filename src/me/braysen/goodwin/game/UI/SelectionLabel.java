package me.braysen.goodwin.game.UI;

import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;

public class SelectionLabel implements Selectable {

    protected Actable action;
    protected boolean isSelected;
    protected int width;
    protected int height;
    protected String text;
    protected Color selectionColor, baseColor;

    public SelectionLabel(String text, Actable action, Color selectionColor, Color baseColor) {
        isSelected = false;
        this.action = action;
        this.text = text;
        this.selectionColor = selectionColor;
        this.baseColor = baseColor;

    }

    public SelectionLabel(String text, Actable action ) {
        this(text, action, new Color(0,0,0,1), new Color(44,250,44, 1));
    }


    @Override
    public void select() {
        isSelected = true;
    }

    @Override
    public void deselect() {
        isSelected = false;
    }

    @Override
    public void act() {
        action.act();
    }

    @Override
    public void render(Graphics g, Manager m, int xBase, int yBase) {
        Color color = baseColor;
        if (isSelected) {
            color = selectionColor;
        }
        g.setColor(color);
        g.drawString(text, xBase, yBase);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
