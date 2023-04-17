package entity.bullets;

import entity.character.Emtity;
import main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BulletBlue extends Interface {
    GameScreen gameScreen;
    Emtity player;
    Emtity competitor;


    public BulletBlue(GameScreen gameScreen, Emtity player, Emtity competitor) {
        this.gameScreen = gameScreen;
        this.player = player;
        this.competitor = competitor;

        defaultValue();
        getBulletImage();
    }

    public void defaultValue() {
        x = player.x - player.width/2;
        y = player.y + player.height/2 - height/2;
        height = 100;
        width = 200;
        speed = 40;
        direction = player.action;
        timeSize = 40;
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
        if(time < timeSize) {
            switch (direction) {
                case "jump":
                case "jump_right":
                case "right":
                    x += speed;
                    break;
                case "jump_left":
                case "left":
                    x -= speed;
                    break;
            }

            // bắn trúng
            if(
                    Math.abs(x + width/2 - competitor.x - competitor.width /2) < competitor.width /2 &&
                    Math.abs(y + height/2 - competitor.y - competitor.height/2) < competitor.height /2 && !isHide
            ) {
                isHide = true;
                competitor.hp --;
            }
        } else {
            switch (direction) {
                case "jump":
                case "jump_right":
                case "right":
                    x = player.x - player.width/2;
                    break;
                case "jump_left":
                case "left":
                    x = player.x - player.width;
                    break;
            }
            y = player.y + player.height/2 - height/2;
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
