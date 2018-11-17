package me.braysen.goodwin.network;

import me.braysen.goodwin.network.packet.Packet;
import me.braysen.goodwin.network.packet.PacketServerUpdate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection extends Thread {

    private NetworkManager networkManager;

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ServerConnection(NetworkManager networkManager, Socket socket) {
        super();
        this.networkManager = networkManager;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());

            this.objectInputStream = new ObjectInputStream(dataInputStream);
            this.objectOutputStream = new ObjectOutputStream(dataOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (socket != null && !socket.isClosed() && socket.isConnected()) {
            try {
                PacketServerUpdate packetServerUpdate =
                        new PacketServerUpdate(networkManager.getEntityManager().getEntities());
                packetServerUpdate.readPacket(objectInputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writePacket(Packet packet) {
        try {
            packet.writePacket(objectOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
