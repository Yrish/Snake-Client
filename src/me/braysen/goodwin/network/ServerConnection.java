package me.braysen.goodwin.network;

import me.braysen.goodwin.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection extends Thread {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ServerConnection(Socket socket) {
        super();
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writePacket(Packet packet) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
