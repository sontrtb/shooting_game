package entity.bullets;

import entity.character.Emtity;
import main.GameScreen;
import main.KeyboardHandle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BulletDefult extends Interface {
    GameScreen gameScreen;
    Emtity player;
    Emtity competitor;


    public BulletDefult(GameScreen gameScreen, Emtity player, Emtity competitor) {
        this.gameScreen = gameScreen;
        this.player = player;
        this.competitor = competitor;

        defaultValue();
        getBulletImage();
    }

    public void defaultValue() {
        x = player.x;
        y = player.y;
        height = 150;
        width = 300;
        speed = 15;
        direction = player.action;
    }

    public void getBulletImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("media/default_1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int time = 0;
    boolean isHide = false;
    public void update() {
        time ++;
        if(time < 80) {
            switch (direction) {
                case "jump":
                    y -= speed;
                    break;
                case "jump_right":
                    x += speed;
                    y -= speed;
                    break;
                case "jump_left":
                    x -= speed;
                    y -= speed;
                    break;
                case "right":
                    x += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
            }

            // bắn trúng
            if(Math.abs(x - competitor.x) < 10 && Math.abs(y - competitor.y) < 10) {
                isHide = true;
                competitor.hp --;
            }
        } else {
            x = player.x;
            y = player.y;
            direction = player.action;
            time = 0;
            isHide = false;
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage bulletImage = image;
        if(!isHide) {
            graphics2D.drawImage(bulletImage, x, y, width, height, null);
        }
    }
}
