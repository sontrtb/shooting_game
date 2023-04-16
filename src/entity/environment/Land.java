package entity.environment;

import main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Land extends Emtity {
    GameScreen gameScreen;
     public Land(GameScreen gameScreen) {
         this.gameScreen = gameScreen;
         defaultValue();
         landImage();
     }

    public void defaultValue() {
        x = 0;
        y = 760;
        height = 100;
        width = 800;
    }

    public void landImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("media/land.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage wallImage = image;
        for(int i = 0; i<2; i++) {
            graphics2D.drawImage(wallImage, x + i*width, y,width, height, null);
        }
    }
}
