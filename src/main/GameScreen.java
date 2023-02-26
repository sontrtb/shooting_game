package main;

import entity.CharacterBlue;
import entity.CharacterRed;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements  Runnable {
    // SETTING
    int FPS = 60;

    Thread gameThread;
    KeyboardHandle handleKeyboard = new KeyboardHandle();
    CharacterBlue character_blue =  new CharacterBlue(this, handleKeyboard);
    CharacterRed character_red =  new CharacterRed(this, handleKeyboard);

    // position player
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
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

        character_blue.draw(graphics2D);
        character_red.draw(graphics2D);

        graphics2D.dispose();
    }
}
