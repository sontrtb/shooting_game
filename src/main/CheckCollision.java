package main;

import entity.character.Character;

public class CheckCollision {
    GameScreen gameScreen;

    public CheckCollision(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void checkCollision(Character player) {
        int playerRightX = player.x  + player.width;
        int playerLeftX = player.x;
        int playerTopY = player.y;
        int playerBottomY = player.y + player.height;

        int wallRightCol = playerRightX/gameScreen.sizeWall;
        int wallLeftCol = playerLeftX/gameScreen.sizeWall;
        int wallTopRow = playerTopY/gameScreen.sizeWall;
        int wallBottomRow = playerBottomY/gameScreen.sizeWall;

        // check di chuyển trái phải, nhảy
        int wallNum1;
        int wallNum2;
       switch (player.action) {
           case "jump":
           case "jump_right":
           case "jump_left":
           case "right":
           case "left":
               wallNum1 = gameScreen.wallManager.mapArray[wallRightCol][wallTopRow];
               wallNum2 = gameScreen.wallManager.mapArray[wallLeftCol][wallTopRow];

               if(wallNum1 == 1 || wallNum2 == 1) {
                   player.isCollision = true;
               }
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
