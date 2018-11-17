package me.braysen.goodwin.network;

import me.braysen.goodwin.game.managers.EntityManager;

import java.net.Socket;

public class NetworkManager {

    private EntityManager entityManager;
    private ServerConnection serverConnection;
    private String ip;
    private int port;

    public NetworkManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createConnection() {
        try {
            Socket socket = new Socket(ip, port);

            this.serverConnection = new ServerConnection(this, socket);
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

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
