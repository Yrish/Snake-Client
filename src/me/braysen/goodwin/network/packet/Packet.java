package me.braysen.goodwin.network.packet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Packet {

    private String name;

    public Packet(String name) {
        this.name = name;
    }

    public void writePacket(ObjectOutputStream objectOutputStream) throws Exception {
        objectOutputStream.writeUTF(name);
    }

    public void readPacket(ObjectInputStream objectInputStream) throws Exception {
        this.name = objectInputStream.readUTF();
    }

}
