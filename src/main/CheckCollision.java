package main;

import entity.character.Emtity;

public class CheckCollision {
    GameScreen gameScreen;

    public CheckCollision(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void checkCollision(Emtity player) {
        int playerRightX = player.x + player.soidArea.x + player.soidArea.width;
        int playerLeftX = player.x + player.soidArea.x;
        int playerTopY = player.y + player.soidArea.y;
        int playerBottomY = player.y + player.soidArea.y + player.soidArea.height;

        int heightWall = gameScreen.wall.height;
        int widthWall = gameScreen.wall.width * gameScreen.wall.numberWidthItem;

        int wallRightX = gameScreen.wall.x;
        int wallLeftX = wallRightX + widthWall;
        int wallTopY = gameScreen.wall.y;
        int wallBottomY = wallTopY + heightWall;

//        System.out.println(playerBottomY + " " + wallBottomY);

       switch (player.action) {
           case "jump":
               if(Math.abs(playerBottomY - wallBottomY) < 5) {
                   player.isCollision = true;
               }
               break;
           case "right":
               break;
           case "left":
               break;

       }
    }
}
