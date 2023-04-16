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
        mapArray = new int[32][18];
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < 1600/50 && row < 900/50) {
                String line = br.readLine();
                while (col < 1600/50) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapArray[col][row] = num;
                    col++;
                }
                if(col == 1600/50) {
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
            wall.image = ImageIO.read(getClass().getResourceAsStream("media/wall.jpg"));
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
        while (col < 1600/50 && row < 900/50) {
            int wallNum = mapArray[col][row];

           if(wallNum == 1) {
               graphics2D.drawImage(wall.image, x, y, 50, 50, null);
           }

            col ++;
            x += 50;

            if(col == 1600/50) {
                col = 0;
                x = 0;
                row ++;
                y += 50;
            }
        }
    }

}
