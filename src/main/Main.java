package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame  j_frame = new JFrame("Game danh nhau");
        j_frame.setSize(1600, 900);
        j_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameScreen gameScreen = new GameScreen();
        j_frame.add(gameScreen);

        j_frame.setVisible(true);

        gameScreen.start();
    }
}