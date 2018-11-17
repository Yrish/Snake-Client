package me.braysen.goodwin.game.states;

import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.Manager;

import java.awt.*;
import java.util.UUID;

public class SinglePlayState extends PlayState {
    public static final String ID = "SINGLE_PLAY";
    private Snake player;

    public SinglePlayState() {
        super(ID);
    }

    public void init(Manager m) {
        super.init(m);
        player = new Snake(0,0, new UUID(40,20), new Color(100,200,100));
        m.getEntityManager().add(player);
    }

    public void tick(Manager m) {
        super.tick(m);
    }
}
