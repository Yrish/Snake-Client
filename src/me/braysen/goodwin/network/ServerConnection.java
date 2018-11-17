package me.braysen.goodwin.network;

import me.braysen.goodwin.network.packet.Packet;

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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writePacket(Packet packet) {
        try {
            packet.writePacket(dataOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
