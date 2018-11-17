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

    public ServerConnection getServerConnection() {
        return serverConnection;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
