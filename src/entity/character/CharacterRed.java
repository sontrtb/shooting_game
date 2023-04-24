package entity.character;

import main.GameScreen;
import main.KeyboardHandle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CharacterRed extends Character {
    GameScreen gameScreen;
    KeyboardHandle keyboardHandle;

    public CharacterRed(GameScreen gameScreen, KeyboardHandle keyboardHandle) {
        this.gameScreen = gameScreen;
        this.keyboardHandle = keyboardHandle;

        defaultValue();
        characterImage();
    }

    public void defaultValue() {
        x = 700;
        y = 100;
        width = 100;
        height = 100;
        hp = 5;
        speedX = 5;
        fallSpeed = 0;
        action = "right";
        jumpSpeed = 40;
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

    boolean isJump = false;
    public void update() {

        isCollision = false;
        gameScreen.checkCollision.checkCollision(this);

        if(keyboardHandle.right1 && keyboardHandle.up1 && !isJump) {
            action = "jump_right";
            if(!isCollision) {
                x += speedX;
                isJump = true;
                fallSpeed = 0;
            }
        }
        else if(keyboardHandle.left1 && keyboardHandle.up1 && !isJump) {
            action = "jump_left";
            if(!isCollision) {
                x -= speedX;
                isJump = true;
                fallSpeed = 0;
            }
        }
        else if(keyboardHandle.right1) {
            action = "right";
            if(!isCollision) {
                x += speedX;
            }
        }
        else if(keyboardHandle.left1) {
            action = "left";
            if(!isCollision) {
                x -= speedX;
            }
        }
        else if(keyboardHandle.up1 && !isJump) {
            action = "jump";
            isJump = true;
            fallSpeed = 0;
        }

        // nhảy
        if(isJump && jumpSpeed > 0) {
            if(!isCollision) {
                y -= jumpSpeed;
                jumpSpeed -= gravitation;
            }else {
                jumpSpeed = 0;
            }
        }


        // rơi tự do
        int reduceGravitation = 4; // hệ số giảm tốc độ rơi
        if(!isCollisionGravitation) {
            y += fallSpeed/reduceGravitation;
            fallSpeed = fallSpeed + gravitation;
        } else {
            fallSpeed = 0;
            isJump = false;
            jumpSpeed = 20;
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
            graphics2D.draw(new Rectangle(x + i*20, y - 50 , 20, 10));
        }
    }
}
