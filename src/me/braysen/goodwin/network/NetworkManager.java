package me.braysen.goodwin.network;

import me.braysen.goodwin.game.entities.Snake;
import me.braysen.goodwin.game.managers.EntityManager;
import me.braysen.goodwin.network.packet.PacketSnake;
import me.braysen.goodwin.network.packet.PacketSnakeMove;

import java.net.Socket;

public class NetworkManager {

    private EntityManager entityManager;
    private ServerConnection serverConnection;
    private String ip = "127.0.0.1";
    private int port = 42087;

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

    public void pushNewSnake(Snake snake) {
        this.sendFreshUpdateSnake(snake);
    }

    public void sendFreshUpdateSnake(Snake snake) {
        PacketSnake packetSnake = new PacketSnake(snake);
        serverConnection.writePacket(packetSnake);
    }

    public void moveSnake(Snake snake) {
        PacketSnakeMove packetSnakeMove = new PacketSnakeMove(snake);
        serverConnection.writePacket(packetSnakeMove);
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
