package me.braysen.goodwin.network.packet;

import me.braysen.goodwin.entities.Snake;

public class PacketUpdateServer extends Packet {

    private Snake snake;

    public PacketUpdateServer(Snake snake) {
        super("up");
        this.snake = snake;
    }

    public void writePacket() {

    }
}
