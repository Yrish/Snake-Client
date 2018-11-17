package me.braysen.goodwin.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Packet {

    private String name;

    public Packet(String name) {
        this.name = name;
    }

    public void writePacket(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(name);
    }

    public void readPacket(DataInputStream dataInputStream) throws IOException {
        this.name = dataInputStream.readUTF();
    }

}
