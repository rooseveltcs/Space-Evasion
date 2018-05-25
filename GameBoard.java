/**
 * Created by ros_gdfulton on 5/22/2018.
 */
import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel {
   
   private static final int NUM_ASTEROIDS = 10;
   private Rocket rocket;
   private Asteroid[] asteroids;
   
   public GameBoard(Rocket r) {
      rocket = r;
      asteroids = new Asteroid[NUM_ASTEROIDS];
   }
    
   public void paintComponent(Graphics g) {
      System.out.println("GameBoard succesfully called!");
      super.paintComponent(g);
      setBackground(Color.BLACK);
      stars(g);
   }
   
   public void turnRocket(int move) {
      if (move > 0) {
         rocket.left();
      }
      if (move < 0) {
         rocket.right();
      }
   }

   private static void stars (Graphics g){
      int xcord = (int) (Math.random() * 2501);
      int ycord = (int) (Math.random() * 1001);
      int width = 10;
      int height = 10;
      for (int i = 1; i < 300; i++) {
         for (int j = 1; j <2; j ++) {
            xcord = (int) (Math.random() * 2501);
            ycord = (int) (Math.random() * 1001);
            width = 10;
            height = 10;
         }          
      }
   }
}
