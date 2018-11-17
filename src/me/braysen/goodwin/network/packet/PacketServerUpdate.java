package me.braysen.goodwin.network.packet;

import java.io.DataInputStream;
import java.io.IOException;

public class PacketServerUpdate extends Packet {


    public PacketServerUpdate() {
        super("down");
    }

    public void readPacket(DataInputStream dataInputStream) throws IOException {
        int sizeOfSnakeUpdate = dataInputStream.readInt();
        for (int i = 0; i < sizeOfSnakeUpdate; i++) {

            int sizeOfCurrentSnakeTrail = dataInputStream.readInt();

            for (int j = 0; j < sizeOfCurrentSnakeTrail; j++) {
                System.out.println("test");
            }
        }
    }
}
