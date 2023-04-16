package entity.character;

import main.GameScreen;
import main.KeyboardHandle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CharacterRed extends Emtity {
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
        width = 100;
        height = 100;
        speed = gameScreen.playerSpeed;
        action = "left";
        jumpSpeed = gameScreen.jumpSpeed;
        gravitation = gameScreen.gravitation;
    }

    public void characterImage() {
        try {
            right = ImageIO.read(getClass().getResourceAsStream("media/character_2_right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("media/character_2_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        isCollision = false;
        gameScreen.checkCollision.checkCollision(this);

        if(keyboardHandle.up1) {
            action = "jump";
            if(!isCollision) {
                y -= gameScreen.jumpSpeed;
            }
        }
        else if(keyboardHandle.right1) {
            action = "right";
            if(!isCollision) {
                x += speed;
            }
        }
        else if(keyboardHandle.left1) {
            action = "left";
            if(!isCollision) {
                x -= speed;
            }
        }

        if(y < 700 && !keyboardHandle.up1) {
            if(!isCollisionGravitation) {
                y += gravitation;
            }
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
        graphics2D.drawImage(imageCharacters, x, y,width, height, null);
    }
}
