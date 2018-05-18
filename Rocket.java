import java.awt.*;

public class Rocket extends MovingObject {
   public Rocket(FloatingPoint p, int angle) {
      super(p, angle);
   }
   
   public void draw(Graphics g) {
      int x = (int)(getPos().getX());
      int y = (int)(getPos().getY());
      Point center = new Point(x, y);
      Point vertex = new Point((int)(x + Math.sin(Math.toRadians(getAngle())) * 20),(int)( y + Math.cos(Math.sin(Math.toRadians(getAngle())) * 20)));
      g.drawLine((int)center.getX(), (int)center.getY(),(int)vertex.getX(),(int) vertex.getY());       
   }
   
   public void drawTriangle(Graphics g, Point p1, Point p2, Point p3) {
      int x1 = (int)p1.getX();
      int x2 = (int)p2.getX();
      int x3 = (int)p3.getX();
      int y1 = (int)p1.getY();
      int y2 = (int)p2.getY();
      int y3 = (int)p3.getY();
      g.drawLine(x1, y1, x2, y2);
      g.drawLine(x2, y2, x3, y3);
      g.drawLine(x1, y1, x3, y3);
   }     
}