import java.awt.*;

class Asteroid {
   public static final int SIZE = 75;
   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(1000, 1000);

      Graphics g = panel.getGraphics();
      g.setColor(Color.RED);
      int x = (int) (Math.random() * 980);
      int y = (int) (Math.random() * 980);
      int w = (int) (Math.random() * SIZE + 25);
      int h = (int) (Math.random() * SIZE + 25);
      
      drawAsteroid(g, x, y, w, h);
   }
   
   public static void drawAsteroid(Graphics g, int x, int y, int w, int h){   
	  // g.drawRect(x, y, w, h);
     g.setColor(Color.GRAY);
      int firstx = (int) (Math.random() * w + x);
      int firsty = (int) (Math.random() * h + y);
      int pointx1 = firstx;
      int pointy1 = firsty;
      for(int i = 1; i <= 4; i++){
         int pointx2 = (int) (Math.random() * w + x);
         int pointy2 = (int) (Math.random() * h + y);
         g.drawLine(pointx1, pointy1, pointx2, pointy2);
         pointx1 = pointx2;
         pointy1 = pointy2;
      }
      g.drawLine(pointx1, pointy1, firstx, firsty);
}
}




