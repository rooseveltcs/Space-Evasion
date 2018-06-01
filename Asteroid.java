import java.awt.*;

public class Asteroid {
   private static final int NUM_POINTS = 3;
   private static final double SCALE_FACTOR = 250.0;
   private static final double MOVEMENT_SPEED = 0.5;
   private Polygon asteroid;
   private int xChange;
   private int yChange;
   private double moveCounter;

   public Asteroid(Point p) {
      int[] xCoords = new int[NUM_POINTS];
      int[] yCoords = new int[NUM_POINTS];
      for (int i = 0; i < NUM_POINTS; i++) {
         xCoords[i] = (int)(Math.random() * SCALE_FACTOR + p.getX());
         yCoords[i] = (int)(Math.random() * SCALE_FACTOR + p.getY());
      }
      //sort(xCoords);
      //sort(yCoords);
      asteroid = new Polygon(xCoords, yCoords, NUM_POINTS);
      xChange = oneOrNegativeOne();
      yChange = oneOrNegativeOne();
      moveCounter = 0;
   }

   public void move() {
      moveCounter += MOVEMENT_SPEED;
      if (moveCounter >= 1.0) {
         for (int i = 0; i < asteroid.xpoints.length; i++) {
            asteroid.xpoints[i] += xChange;
            asteroid.ypoints[i] += yChange;
         }
         asteroid = new Polygon(asteroid.xpoints, asteroid.ypoints, NUM_POINTS);
         moveCounter = 0;
      }
   }
   
   public void draw(Graphics g){
      g.setColor(Color.WHITE);
      g.fillPolygon(asteroid);
   }

   public void changeMovement() {
      xChange = oneOrNegativeOne();
      yChange = oneOrNegativeOne();
   }

   public Polygon getShape() {
      return asteroid;
   }

   private static void sort(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         int min = i;
         for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
               int temp = arr[j];
               arr[j] = arr[min];
               arr[min] = temp;
            }
         }
      }
   }

   private static int oneOrNegativeOne() {
      int a = (int)Math.round(Math.random());
      if (a == 0) {
         return -1;
      } else {
         return 1;
      }
   }
}

