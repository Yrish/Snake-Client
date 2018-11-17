package me.braysen.goodwin.network;

import java.net.Socket;

public class NetworkManager {

    private ServerConnection serverConnection;
    private String ip;
    private int port;

    public NetworkManager() {

    }

    public void createConnection() {
        try {
            Socket socket = new Socket(ip, port);

            this.serverConnection = new ServerConnection(socket);
            this.serverConnection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
