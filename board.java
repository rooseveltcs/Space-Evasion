/**
 * Created by ros_gdfulton on 5/22/2018.
 */
import java.awt.*;

public class board {
    public static void main(String[]args) {
        DrawingPanel panel = new DrawingPanel(2500, 1000);
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.BLACK);

    }

    public static void stars (Graphics g, int x, int y){
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


    }

    public static void drawStar (Graphics g, int xcord, in ycord)