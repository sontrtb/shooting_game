package entity.character;

import java.awt.image.BufferedImage;

public class Character {
    public int x, y;
    public int width, height;
    public int speedX, fallSpeed, jumpSpeed, gravitation;
    public int hp;
    public BufferedImage right, left, jump, jump_right, jump_left;
    public String action;
    public boolean isCollision = false, isCollisionGravitation = false;
}
