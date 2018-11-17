package me.braysen.goodwin.network;

import me.braysen.goodwin.network.packet.PacketServerUpdate;
import me.braysen.goodwin.network.packet.PacketUpdateServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerConnection extends Thread {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ServerConnection(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (socket != null && !socket.isClosed() && socket.isConnected()) {
            try {
                PacketServerUpdate packetServerUpdate = new PacketServerUpdate();
                packetServerUpdate.readPacket(dataInputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pushPacketUpdateServer(PacketUpdateServer packetUpdateServer) {
        try {
            packetUpdateServer.writePacket(dataOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
