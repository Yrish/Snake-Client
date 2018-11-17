package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.states.*;

import java.util.HashMap;

public class GameStateManager {
    private HashMap<String, GameState> suspendedStates;
    private GameState currentState;
    private Manager man;

    public GameStateManager() {
        suspendedStates = new HashMap<>();
    }

    public void init(Manager m) {
        man = m;
    }

    public void setCurrentState(String id) {
        GameState g = suspendedStates.getOrDefault(id, null);
        if (g == null) {
            switch (id) {
                case SinglePlayState.ID:
                    g = new SinglePlayState();
                    break;
                case MultiplayerPlayState.ID:
                    g = new MultiplayerPlayState();
                    break;
                case SelectionState.ID:
                    g = new SelectionState();
                    break;
                default:
                    throw new RuntimeException("Can not find State with id: '" + id + "'");
            }
            suspendedStates.put(g.getId(), g);
        }
        currentState = g;
        g.init(man);
    }

    public void destroyState(String id) {
        suspendedStates.remove(id);
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
