package me.braysen.goodwin.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketServer extends Packet {

    public PacketServer() {
        super("server");
    }

    @Override
    public void writePacket(DataOutputStream dataOutputStream) throws IOException {
        super.writePacket(dataOutputStream);

    }

    @Override
    public void readPacket(DataInputStream dataInputStream) throws IOException {
        super.readPacket(dataInputStream);

    }
}
