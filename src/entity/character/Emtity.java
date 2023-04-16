package entity.character;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Emtity {
    public int x, y;
    public int speed, jumpSpeed, gravitation;
    public BufferedImage right, left;
    public String action;
    public Rectangle soidArea;
    public boolean isCollision = false;
}
