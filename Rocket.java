import java.awt.*;

public class Rocket extends MovingObject {

   public static final int SCALE_FACTOR = 20;

   public Rocket(FloatingPoint p, int angle) {
      super(p, angle);
   }

   public void draw(Graphics g) {
      int x = (int)(getPos().getX());
      int y = (int)(getPos().getY());
      //Point center = new Point(x, y);
      Point vertex = new Point((int)(x + Math.round(Math.cos(Math.toRadians(getAngle()))) * SCALE_FACTOR),(int)( y - Math.round(Math.sin((Math.toRadians(getAngle())))) * SCALE_FACTOR));
      Point rightLeg = new Point((int)(x + Math.round(Math.cos(Math.toRadians(getAngle() - 90))) * SCALE_FACTOR / 2),(int)( y - Math.round(Math.sin((Math.toRadians(getAngle() - 90)))) * SCALE_FACTOR / 2));
      Point leftLeg = new Point((int)(x + Math.round(Math.cos(Math.toRadians(getAngle() + 90))) * SCALE_FACTOR / 2),(int)( y - Math.round(Math.sin((Math.toRadians(getAngle() + 90)))) * SCALE_FACTOR / 2));
      drawTriangle(g, vertex, leftLeg, rightLeg);
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