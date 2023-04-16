package main;

import entity.character.Emtity;

public class CheckCollision {
    GameScreen gameScreen;

    public CheckCollision(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void checkCollision(Emtity player) {
        int playerRightX = player.x  + player.width;
        int playerLeftX = player.x;
        int playerTopY = player.y;
        int playerBottomY = player.y + player.height;

        int wallRightCol = playerRightX/50;
        int wallLeftCol = playerLeftX/50;
        int wallTopRow = playerTopY/50;
        int wallBottomRow = playerBottomY/50;

        // check di chuyển trái phải, nhảy
        int wallNum1;
        int wallNum2;
       switch (player.action) {
           case "jump":
               wallNum1 = gameScreen.wallManager.mapArray[wallRightCol][wallTopRow];
               wallNum2 = gameScreen.wallManager.mapArray[wallLeftCol][wallTopRow];

               if(wallNum1 == 1 || wallNum2 == 1) {
                   player.isCollision = true;
               }
               break;
           case "right":
               break;
           case "left":
               break;
       }


       // check rơi tự do
        int wallNum3 = gameScreen.wallManager.mapArray[wallRightCol][wallBottomRow];
        int wallNum4 = gameScreen.wallManager.mapArray[wallLeftCol][wallBottomRow];

        if(wallNum3 == 1 || wallNum4 == 1) {
            player.isCollisionGravitation = true;
        } else {
            player.isCollisionGravitation = false;
        }
    }
}
