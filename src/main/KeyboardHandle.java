package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandle implements KeyListener {

    public boolean up1, left1, right1, shoot1, up2, left2, right2;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W) {
            up1 = true;
        }
        if(keyCode == KeyEvent.VK_D) {
            right1 = true;
        }
        if(keyCode == KeyEvent.VK_A) {
            left1 = true;
        }
        if(keyCode == KeyEvent.VK_UP) {
            up2 = true;
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            right2 = true;
        }
        if(keyCode == KeyEvent.VK_LEFT) {
            left2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W) {
            up1 = false;
        }
        if(keyCode == KeyEvent.VK_D) {
            right1 = false;
        }
        if(keyCode == KeyEvent.VK_A) {
            left1 = false;
        }
        if(keyCode == KeyEvent.VK_UP) {
            up2 = false;
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            right2 = false;
        }
        if(keyCode == KeyEvent.VK_LEFT) {
            left2 = false;
        }
    }
}
