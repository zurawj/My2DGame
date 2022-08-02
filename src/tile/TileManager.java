package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapArray;
    public TileManager(GamePanel gp) {
        this.gp = gp;
        mapArray = new int[gp.maxScreenCol][gp.maxScreenRow];
        tile = new Tile[10]; //10 kinds of tiles

        getTileImage();


            readMap();


    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readMap() {

        try{

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Drugie\\IdeaProjects\\My2DGame\\res\\maps\\map1.txt"));
         //   BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col< gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while(col <gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapArray[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }

       /* File file = new File(
                "C:\\Users\\Drugie\\IdeaProjects\\My2DGame\\res\\maps\\map1.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;

        // Condition holds true till
        // there is character in a string
        int i = 0;
        while ((st = br.readLine()) != null){
            String[] split = st.split(" ");
            while(split.)
            for (int j = 0; j < 16; j++) {
                    if(!split[j].equals(" ")){
                        System.out.println(split[j]);
                }

            }
        }
       // System.out.println(mapArray);
            // Print the string*/

    }


    public void draw(Graphics2D g2) {
        //grass

  /*      File file = new File("/maps/map1.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                System.out.println(sc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        for (int i = 0; i < gp.maxScreenCol; i++) {
            for (int j = 0; j < gp.maxScreenRow; j++) {


                g2.drawImage(tile[mapArray[i][j]].image, i * gp.tileSize, j * gp.tileSize, gp.tileSize, gp.tileSize, null);
            }


        }

    }
}
