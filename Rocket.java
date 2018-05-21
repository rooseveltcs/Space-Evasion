import java.awt.*;

public class Rocket extends MovingObject {

   public static final int SCALE_FACTOR = 20;

   public Rocket(FloatingPoint p, int angle) {
      super(p, angle);
   }

   public void draw(Graphics g) {
      double x = (getPos().getX());
      double y = (getPos().getY());
      //Point center = new Point(x, y);
      FloatingPoint vertex = new FloatingPoint((x + Math.cos(Math.toRadians(getAngle())) * SCALE_FACTOR),( y - Math.sin((Math.toRadians(getAngle()))) * SCALE_FACTOR));
      FloatingPoint rightLeg = new FloatingPoint((x + Math.cos(Math.toRadians(getAngle() - 90)) * SCALE_FACTOR / 2),( y - Math.sin((Math.toRadians(getAngle() - 90))) * SCALE_FACTOR / 2));
      FloatingPoint leftLeg = new FloatingPoint((x + Math.cos(Math.toRadians(getAngle() + 90)) * SCALE_FACTOR / 2),( y - Math.sin((Math.toRadians(getAngle() + 90))) * SCALE_FACTOR / 2));
      drawTriangle(g, vertex, leftLeg, rightLeg);
   }

   public void drawTriangle(Graphics g, FloatingPoint p1, FloatingPoint p2, FloatingPoint p3) {
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