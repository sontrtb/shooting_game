package entity.character;

import main.GameScreen;
import main.KeyboardHandle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CharacterBlue extends Emtity {
    GameScreen gameScreen;
    KeyboardHandle keyboardHandle;

    public CharacterBlue(GameScreen gameScreen, KeyboardHandle keyboardHandle) {
        this.gameScreen = gameScreen;
        this.keyboardHandle = keyboardHandle;
        defaultValue();
        characterImage();
    }

    public void defaultValue() {
        x = 100;
        y = 100;
        speed = 4;
        action = "right";
    }

    public void characterImage() {
        try {
            right = ImageIO.read(getClass().getResourceAsStream("media/character_1_right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("media/character_1_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyboardHandle.up2) {
            action = "jump";
            y -= speed;
        }
        if(keyboardHandle.right2) {
            action = "right";
            x += speed;
        }
        if(keyboardHandle.left2) {
            action = "left";
            x -= speed;
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage imageCharacters = right;
        switch (action) {
            case "right":
                imageCharacters = right;
                break;
            case "left":
                imageCharacters = left;
                break;
        }
        graphics2D.drawImage(imageCharacters, x, y,100, 100, null);
    }
}
