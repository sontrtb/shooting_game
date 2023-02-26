package entity;

import main.GameScreen;
import main.KeyboardHandle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CharacterRed extends Emtity{
    GameScreen gameScreen;
    KeyboardHandle keyboardHandle;

    public CharacterRed(GameScreen gameScreen, KeyboardHandle keyboardHandle) {
        this.gameScreen = gameScreen;
        this.keyboardHandle = keyboardHandle;
        defaultValue();
        characterImage();
    }

    public void defaultValue() {
        x = 200;
        y = 200;
        speed = 4;
        action = "left";
    }

    public void characterImage() {
        try {
            right = ImageIO.read(getClass().getResourceAsStream("media/characters/character_2_right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("media/characters/character_2_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyboardHandle.up1) {
            if(y < 0) return;
            action = "jump";
            y -= speed;
        }
        if(keyboardHandle.down1) {
            if(y > 900 - 100) return;
            action = "jump";
            y += speed;
        }
        if(keyboardHandle.right1) {
            if(x > 1600 - 100) return;
            action = "right";
            x += speed;
        }
        if(keyboardHandle.left1) {
            if(x < 0) return;
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
