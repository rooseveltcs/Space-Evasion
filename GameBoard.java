/**
 * Created by ros_gdfulton on 5/22/2018.
 */
import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel {
   
   private static final int NUM_ASTEROIDS = 10;
   private static final Point SCORE_PLACEMENT = new Point(1200, 50);
   private Rocket rocket;
   private Asteroid[] asteroids;
   private boolean crashed;
   private double score;
   
   public GameBoard() {
      score = 0;
      crashed = false;
      setSize(BoardFrame.DIMENSION);
      rocket = new Rocket();
      asteroids = new Asteroid[NUM_ASTEROIDS];
      for (int i = 0; i < NUM_ASTEROIDS; i++) {
         Point p = new Point((int)(BoardFrame.DIMENSION.getWidth() / NUM_ASTEROIDS * i), (int)BoardFrame.DIMENSION.getHeight() - 100);
         asteroids[i] = new Asteroid(p);
      }
   }

   public void playGame() throws InterruptedException {
      while (!isCrashed()) {
         repaint();
         Thread.sleep(10);
         rocket.move(2);
      }
   }

   public void printRocket() {
      System.out.println(rocket);
   }

   public void resetRocket() {
      System.out.println("Rocket Reset!");
      rocket = new Rocket();
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
         score += 0.1;
         paintScore(g);
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
            if (asteroids[i].getShape().contains(rocket.getRightLeg().getX(), rocket.getRightLeg().getY())) {
               crashed = true;
            }
            if (asteroids[i].getShape().contains(rocket.getLeftLeg().getX(), rocket.getLeftLeg().getY())) {
               crashed = true;
            }
         }
         if (!pointIsInDimension(rocket.getVertex(), BoardFrame.DIMENSION)) {
            System.out.println("Out of Bounds!");
            crashed = true;
         }
         for (int i = 0; i < asteroids.length; i++) {
            asteroids[i].move();
            if (!asteroids[i].getShape().intersects(0,0,BoardFrame.DIMENSION.getWidth(),BoardFrame.DIMENSION.getHeight())) {
               asteroids[i].changeMovement();
            }
         }
      }
   }

   public boolean isCrashed() {
      return crashed;
   }

   public void paintScore(Graphics g) {
      g.setColor(Color.WHITE);
      g.drawString("Score:" + (int)score,(int)SCORE_PLACEMENT.getX(), (int)SCORE_PLACEMENT.getY());
   }

   public double getScore() {
      return score;
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

   private static boolean pointIsInDimension(Point p, Dimension d) {
      return p.getX() <= d.getWidth() && p.getX() >= 0 && p.getY() <= d.getHeight() && p.getY() >= 0;
   }
}
