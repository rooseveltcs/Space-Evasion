import java.awt.*;

class Asteroid {
   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(1000, 1000);

      Graphics g = panel.getGraphics();
      g.setColor(Color.GRAY);
      int x = (int) (Math.random() * 1001);
      int y = (int) (Math.random() * 1001);
      int w = (int) (Math.random() * 10 + 5);
      int h = (int) (Math.random() * 10 + 5);
      
      drawAsteroid(g, x, y, w, h);
   }
   
   public static void drawAsteroid(Graphics g, int x, int y, int w, int h){   
	   g.fillRect(x, y, w, h);
}
}

