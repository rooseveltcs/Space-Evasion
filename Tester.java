import java.awt.*;

public class Tester {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(100,100);
      Graphics g = panel.getGraphics();
      Rocket r = new Rocket(new FloatingPoint(20, 20), 5);
      r.draw(g);      
   }
}