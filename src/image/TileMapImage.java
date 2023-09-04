package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileMapImage {
    public static final int TILE_MAP_PNG_WIDTH = 1000;
    public static final int TILE_MAP_PNG_HEIGHT = 1000;
    public static final int SUB_IMAGE_WIDTH = 100;
    public static final int SUB_IMAGE_HEIGHT = 100;
    static final int TILE_AMOUNT_HORIZONTAL = 2;
    static final int TILE_AMOUNT_VERTICAL = 1;
    public static final int IMAGE_AMOUNT = TILE_AMOUNT_HORIZONTAL * TILE_AMOUNT_VERTICAL;
    public static final int IMAGE_WIDTH = SUB_IMAGE_WIDTH * TILE_AMOUNT_HORIZONTAL;
    public static final int IMAGE_HEIGHT = SUB_IMAGE_HEIGHT * TILE_AMOUNT_VERTICAL;
    private final Image[] images;
    public TileMapImage() {
        images = new Image[IMAGE_AMOUNT];
    }
    public Image[] loadImages() {
        try {
            BufferedImage all = ImageIO.read(new File("src/image/TileMap.png"));
            int index = 0;
            for (int y = 0; y < IMAGE_HEIGHT; y += SUB_IMAGE_HEIGHT){
                for (int x = 0; x < IMAGE_WIDTH; x += SUB_IMAGE_WIDTH) {
                    images[index] = all.getSubimage(x, y, SUB_IMAGE_WIDTH, SUB_IMAGE_HEIGHT)
                            .getScaledInstance(32, 32, BufferedImage.SCALE_SMOOTH);
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}