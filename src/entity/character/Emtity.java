package entity.character;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Emtity {
    public int x, y;
    public int width, height;
    public int speedX, fallSpeed, jumpSpeed, gravitation;
    public int hp;
    public BufferedImage right, left;
    public String action;
    public boolean isCollision = false, isCollisionGravitation = false;
}
