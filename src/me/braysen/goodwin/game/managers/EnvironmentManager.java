package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.environment.Environment;

import java.awt.*;

public class EnvironmentManager {
    private Environment env;

    public int getWidth() {
        return env.getWidth();
    }


    public int getHeight() {
        return env.getHeight();
    }

    public Environment getEnvironment() {
        return env;
    }

    public void setEnvironment(Environment env) {
        this.env = env;
    }

    public void render(Graphics g, Manager m) {
        if (this.env != null) {
            this.env.render(g, m);
        }
    }
}
