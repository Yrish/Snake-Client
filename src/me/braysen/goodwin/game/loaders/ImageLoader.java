package me.braysen.goodwin.game.loaders;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private static char sep = File.separatorChar;

    public static BufferedImage loadImage(String imageName) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(imageName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
