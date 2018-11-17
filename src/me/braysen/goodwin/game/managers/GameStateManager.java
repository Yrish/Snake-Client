package me.braysen.goodwin.game.managers;

import me.braysen.goodwin.game.states.GameState;
import me.braysen.goodwin.game.states.PlayState;
import me.braysen.goodwin.game.states.SelectionState;

import java.util.HashMap;

public class GameStateManager {
    private HashMap<String, GameState> suspendedStates;
    private GameState currentState;

    public GameStateManager() {
        suspendedStates = new HashMap<>();
    }

    public void setCurrentState(String id) {
        GameState g = suspendedStates.getOrDefault(id, null);
        if (g == null) {
            switch (id) {
                case PlayState.ID:
                    g = new PlayState();
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
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
