import java.awt.*;

public class Rocket extends MovingObject {
   private int angle;

   public static final int SCALE_FACTOR = 30;

   public Rocket(FloatingPoint p, int angle) {
      super(p);
      this.angle = angle;
   }

   public void move(int move) {
      double x = (Math.cos(Math.toRadians(angle)) * move + getPos().getX());
      double y = (-Math.sin(Math.toRadians(angle)) * move + getPos().getY());
      setPoint(x, y);
   }

   public void draw(Graphics g) {
      g.setColor(Color.WHITE);
      double x = (getPos().getX());
      double y = (getPos().getY());
      //Point center = new Point(x, y);
      FloatingPoint vertex = new FloatingPoint((x + Math.cos(Math.toRadians(angle)) * SCALE_FACTOR),( y - Math.sin((Math.toRadians(angle))) * SCALE_FACTOR));
      FloatingPoint rightLeg = new FloatingPoint((x + Math.cos(Math.toRadians(angle - 90)) * SCALE_FACTOR / 3),( y - Math.sin((Math.toRadians(angle - 90))) * SCALE_FACTOR / 3));
      FloatingPoint leftLeg = new FloatingPoint((x + Math.cos(Math.toRadians(angle + 90)) * SCALE_FACTOR / 3),( y - Math.sin((Math.toRadians(angle + 90))) * SCALE_FACTOR / 3));
      drawTriangle(g, vertex, leftLeg, rightLeg);
   }

   public void drawTriangle(Graphics g, FloatingPoint p1, FloatingPoint p2, FloatingPoint p3) {
      int[] xCoords = new int[3];
      int[] yCoords = new int[3];
      xCoords[0] = (int)p1.getX();
      xCoords[1] = (int)p2.getX();
      xCoords[2] = (int)p3.getX();
      yCoords[0] = (int)p1.getY();
      yCoords[1]= (int)p2.getY();
      yCoords[2] = (int)p3.getY();
      Polygon triangle = new Polygon(xCoords, yCoords, 3);
      g.drawPolygon(triangle);
   }


   public void left() {
      angle += 3;
   }

   public void right() {
      angle -= 3;
   }

   public Point getVertex() {
      double x = (getPos().getX());
      double y = (getPos().getY());
      return new Point((int)(x + Math.cos(Math.toRadians(angle)) * SCALE_FACTOR),(int)( y - Math.sin((Math.toRadians(angle))) * SCALE_FACTOR));
   }
}