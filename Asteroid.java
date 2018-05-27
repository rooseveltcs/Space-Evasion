import java.awt.*;

public class Asteroid {
   private static final int NUM_POINTS = 3;
   private static final double SCALE_FACTOR = 500.0;
   private Polygon asteroid;

   public Asteroid(Point p) {
      int[] xCoords = new int[NUM_POINTS];
      int[] yCoords = new int[NUM_POINTS];
      for (int i = 0; i < NUM_POINTS; i++) {
         xCoords[i] = (int)(Math.random() * SCALE_FACTOR + p.getX());
         yCoords[i] = (int)(Math.random() * SCALE_FACTOR + p.getY());
      }
      sort(xCoords);
      sort(yCoords);
      asteroid = new Polygon(xCoords, yCoords, NUM_POINTS);
   }
   
   public void draw(Graphics g){
      g.setColor(Color.WHITE);
      g.fillPolygon(asteroid);
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
}

