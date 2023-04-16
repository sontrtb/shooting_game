package entity.environment;

import main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Wall extends Emtity {
    GameScreen gameScreen;

     public Wall(GameScreen gameScreen) {
         this.gameScreen = gameScreen;
         defaultValue();
         wallImage();
     }

    public void defaultValue() {
        x = 500;
        y = 500;
        height = 50;
        width = 50;
        numberWidthItem = 10;
    }

    public void wallImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("media/land.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage wallImage = image;
        for(int i = 0; i<numberWidthItem; i++) {
            graphics2D.drawImage(wallImage, x + i*width, y,width, height, null);
        }
    }
}
