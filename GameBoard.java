/**
 * Created by ros_gdfulton on 5/22/2018.
 */
import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel {
    
    public void paintComponent(Graphics g) {
      System.out.println("GameBoard succesfully called!");
      super.paintComponent(g);
      stars(g);
    }

    private static void stars (Graphics g, int x, int y){
        for (int i = 1; i < 300; i++) {
            for (int j = 1; j <2; j ++) {
                int xcord = (int) (Math.random() * 2501);
                int ycord = (int) (Math.random() * 1001);
                int width = 10;
                int height = 10;
            }
            drawStar(g, xcord, ycord, width, height);

            }
            }



         private static void drawStar (Graphics g, int xcord, in ycord) {
         }



        


    }

    