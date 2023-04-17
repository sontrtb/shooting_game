package main;

import entity.background.Background;
import entity.bullets.BulletBlue;
import entity.bullets.BulletRed;
import entity.character.CharacterBlue;
import entity.character.CharacterRed;
import entity.environment.WallManager;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements  Runnable {
    // SETTING
    int FPS = 60;
    public int gravitation = 1;

    public int sizeWall = 50;
    public int sizeCol = 1600/sizeWall;
    public int sizeRow = 900/sizeWall;
    public boolean isRunning = true;

    //
    Thread gameThread;
    Background background = new Background(this);
    KeyboardHandle handleKeyboard = new KeyboardHandle();
    CharacterBlue character_blue =  new CharacterBlue(this, handleKeyboard);
    CharacterRed character_red =  new CharacterRed(this, handleKeyboard);
    WallManager wallManager = new WallManager(this);

    BulletRed bullet_red = new BulletRed(this, character_red, character_blue);
    BulletBlue bullet_blue = new BulletBlue(this, character_blue, character_red);

    public CheckCollision checkCollision = new CheckCollision(this);

    // position player

    public GameScreen () {
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.addKeyListener(handleKeyboard);
        this.setFocusable(true);
    }

    public void start () {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long delayTime = 1000 / FPS;

        while (isRunning) {
            update();
            repaint();

            try {
                Thread.sleep(delayTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update() {
        character_blue.update();
        character_red.update();

        bullet_red.update();
        bullet_blue.update();

        if(character_red.hp == 0 || character_blue.hp == 0) {
            isRunning = false;

        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;

        background.draw(graphics2D);
        wallManager.draw(graphics2D);

        character_blue.draw(graphics2D);
        character_red.draw(graphics2D);

        bullet_red.draw(graphics2D);
        bullet_blue.draw(graphics2D);

        graphics2D.dispose();
    }
}
