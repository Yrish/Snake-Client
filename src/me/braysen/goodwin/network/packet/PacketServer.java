package me.braysen.goodwin.network.packet;

import me.braysen.goodwin.entities.Snake;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PacketServer extends Packet {

    private Snake snake;

    public PacketServer(Snake snake) {
        super("server");
        this.snake = snake;
    }

    @Override
    public void writePacket(ObjectOutputStream objectOutputStream) throws Exception {
        super.writePacket(objectOutputStream);

        PacketSnake packetSnake = new PacketSnake(snake);
        packetSnake.writePacket(objectOutputStream);
    }

    @Override
    public void readPacket(ObjectInputStream objectInputStream) throws Exception {
        super.readPacket(objectInputStream);
    }
}
