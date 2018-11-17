package me.braysen.goodwin.network.packet;


import me.braysen.goodwin.entities.Snake;

import java.awt.Point;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class PacketUpdateServer extends Packet {

    private Snake snake;

    public PacketUpdateServer(Snake snake) {
        super("up");
        this.snake = snake;
    }

    public void writePacket(DataOutputStream dataOutputStream) throws IOException {
        ArrayList<Point> snakeTrail = snake.getTrail();

        // Write UUID
        UUID snakeUUID = snake.getUUID();
        dataOutputStream.writeLong(snakeUUID.getMostSignificantBits());
        dataOutputStream.writeLong(snakeUUID.getLeastSignificantBits());

        // Write Direction
        dataOutputStream.write(snake.getDirection().getDataCode());

        // Write Trail
        dataOutputStream.write(snakeTrail.size()); // Write length of snake's x and y map.
        for (Point point : snakeTrail) {
            dataOutputStream.write(point.x);
            dataOutputStream.write(point.y);
        }
    }
}
