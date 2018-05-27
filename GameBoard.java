/**
 * Created by ros_gdfulton on 5/22/2018.
 */
import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel {
   
   private static final int NUM_ASTEROIDS = 10;
   private Rocket rocket;
   private Asteroid[] asteroids;
   private boolean crashed;
   
   public GameBoard(Rocket r) {
      crashed = false;
      setSize(2000,1500);
      rocket = r;
      asteroids = new Asteroid[NUM_ASTEROIDS];
      for (int i = 0; i < NUM_ASTEROIDS; i++) {
         Point p = new Point((int)(getSize().getWidth() / NUM_ASTEROIDS * i), (int)(getSize().getHeight() / NUM_ASTEROIDS * i));
         asteroids[i] = new Asteroid(p);
      }
   }
    
   public void paintComponent(Graphics g) {
      //System.out.println("GameBoard succesfully called!");
      super.paintComponent(g);
      //stars(g);
   }
   
   public void turnRocket(int move) {
      if (move > 0) {
         rocket.left();
      }
      if (move < 0) {
         rocket.right();
      }
   }

   public void paint(Graphics g) {
      super.paint(g);
      if (!crashed) {
         //System.out.println("Paint was called!");
         setBackground(Color.BLACK);
         rocket.draw(g);
         for (Asteroid a : asteroids) {
            a.draw(g);
         }
         for (int i = 0; i < NUM_ASTEROIDS; i++) {
            if (asteroids[i].getShape().contains(rocket.getVertex().getX(), rocket.getVertex().getY())) {
               crashed = true;
            }
         }
      } else {
         setBackground(Color.WHITE);
         g.drawString("You lost", 500, 500);
      }
   }

   public boolean isCrashed() {
      return crashed;
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
