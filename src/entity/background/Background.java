package entity.background;

import main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {
    GameScreen gameScreen;
    BufferedImage background;
    public Background (GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        characterImage();
    }

    public void characterImage() {
        try {
            background = ImageIO.read(getClass().getResourceAsStream("media/back_ground_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(background, 0, 0,1600, 900, null);
    }
}
