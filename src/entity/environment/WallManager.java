package entity.environment;

import main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WallManager {
    GameScreen gameScreen;
    public Wall wall;

    public int mapArray[][];

    public WallManager(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        wall = new Wall();
        wallImage();
        mapArray = new int[gameScreen.sizeCol][gameScreen.sizeRow];
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gameScreen.sizeCol && row < gameScreen.sizeRow) {
                String line = br.readLine();
                while (col < gameScreen.sizeCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapArray[col][row] = num;
                    col++;
                }
                if(col == gameScreen.sizeCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void wallImage() {
        try {
            wall.image = ImageIO.read(getClass().getResourceAsStream("media/wall.png"));
            wall.isCollision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gameScreen.sizeCol && row < gameScreen.sizeRow) {
            int wallNum = mapArray[col][row];

           if(wallNum == 1) {
               graphics2D.drawImage(wall.image, x, y, gameScreen.sizeWall, gameScreen.sizeWall, null);
           }

            col ++;
            x += gameScreen.sizeWall;

            if(col == gameScreen.sizeCol) {
                col = 0;
                x = 0;
                row ++;
                y += gameScreen.sizeWall;
            }
        }
    }

}
