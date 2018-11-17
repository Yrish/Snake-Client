package me.braysen.goodwin.network.packet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PacketSnakeMove extends Packet {

    public PacketSnakeMove() {
        super("move");
    }

    @Override
    public void writePacket(ObjectOutputStream objectOutputStream) throws Exception {
        super.writePacket(objectOutputStream);


    }

    @Override
    public void readPacket(ObjectInputStream objectInputStream) throws Exception {
        super.readPacket(objectInputStream);
    }
}
