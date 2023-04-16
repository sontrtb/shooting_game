package main;


import entity.background.Background;
import entity.character.CharacterBlue;
import entity.character.CharacterRed;
import entity.environment.Wall;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements  Runnable {
    // SETTING
    int FPS = 60;
    public int playerSpeed = 1;
    public int gravitation = 3;
    public int jumpSpeed = 5;
    public int widthPlayer = 100;
    public int heightPlayer = 100;


    //
    Thread gameThread;
    Background background = new Background(this);
    KeyboardHandle handleKeyboard = new KeyboardHandle();
    CharacterBlue character_blue =  new CharacterBlue(this, handleKeyboard);
    CharacterRed character_red =  new CharacterRed(this, handleKeyboard);
    Wall wall = new Wall(this);

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
        int delayTime = 1000 / FPS;
        double nextDrawTime = System.nanoTime() + delayTime;

        while (true) {
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
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;

        background.draw(graphics2D);

        character_blue.draw(graphics2D);
        character_red.draw(graphics2D);

        wall.draw(graphics2D);

        graphics2D.dispose();
    }
}
