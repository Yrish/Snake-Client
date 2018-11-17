package me.braysen.goodwin.game.network;

import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.EntityManager;
import me.braysen.goodwin.network.NetworkManager;

import java.util.UUID;

public class NetworkInterface {

    private EntityManager entityManager;
    private NetworkManager networkManager;

    public NetworkInterface(EntityManager entityManager, NetworkManager networkManager) {
        this.entityManager = entityManager;
        this.networkManager = networkManager;
    }

    public Snake createSnake() {
        return null;
    }

    public void updateSnake(UUID uuid) {

    }

}
