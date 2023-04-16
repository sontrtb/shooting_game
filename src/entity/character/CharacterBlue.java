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
        x = 1300;
        y = 200;
        width = 100;
        height = 100;
        hp = 10;
        speed = gameScreen.playerSpeed;
        action = "right";
        jumpSpeed = gameScreen.jumpSpeed;
        gravitation = gameScreen.gravitation;
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
        isCollision = false;
        gameScreen.checkCollision.checkCollision(this);

        if(keyboardHandle.right2 && keyboardHandle.up2) {
            action = "jump_right";
            if(!isCollision) {
                x += speed;
                y -= gameScreen.jumpSpeed;
            }
        }
        else if(keyboardHandle.left2 && keyboardHandle.up2) {
            action = "jump_left";
            if(!isCollision) {
                x -= speed;
                y -= gameScreen.jumpSpeed;
            }
        }
        else if(keyboardHandle.right2) {
            action = "right";
            if(!isCollision) {
                x += speed;
            }
        }
        else if(keyboardHandle.left2) {
            action = "left";
            if(!isCollision) {
                x -= speed;
            }
        } else if(keyboardHandle.up2) {
            action = "jump";
            if(!isCollision) {
                y -= gameScreen.jumpSpeed;
            }
        }

        if(y < 700 && !keyboardHandle.up2) {
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
        for(int i = 0; i < hp; i++) {
            graphics2D.draw(new Rectangle(x + i*25, y - 50 , 25, 10));
        }
    }
}

