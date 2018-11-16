package me.braysen.goodwin.network;

public class NetworkManager {

    private ServerConnection serverConnection;

    public NetworkManager() {

    }

    public void createConnection() {
        this.serverConnection = new ServerConnection();
        this.serverConnection.start();
    }

}
