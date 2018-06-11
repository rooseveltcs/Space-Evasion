import java.awt.*;

public class Rocket {
   public static final double STARTING_XCOORD = 750.0;
   public static final double STARTING_YCOORD = 0.0;
   public static final int ANGLE = 270;
   public static final int SCALE_FACTOR = 30;
   private int angle;
   private FloatingPoint pos;

   public Rocket() {
      pos = new FloatingPoint(STARTING_XCOORD, STARTING_YCOORD);
      this.angle = ANGLE;
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
   
   public Polygon getPolygon() {
      double x = (getPos().getX());
      double y = (getPos().getY());
      FloatingPoint vertex = new FloatingPoint((x + Math.cos(Math.toRadians(angle)) * SCALE_FACTOR),( y - Math.sin((Math.toRadians(angle))) * SCALE_FACTOR));
      FloatingPoint rightLeg = new FloatingPoint((x + Math.cos(Math.toRadians(angle - 90)) * SCALE_FACTOR / 3),( y - Math.sin((Math.toRadians(angle - 90))) * SCALE_FACTOR / 3));
      FloatingPoint leftLeg = new FloatingPoint((x + Math.cos(Math.toRadians(angle + 90)) * SCALE_FACTOR / 3),( y - Math.sin((Math.toRadians(angle + 90))) * SCALE_FACTOR / 3));
      int[] xCoords = new int[3];
      int[] yCoords = new int[3];
      xCoords[0] = (int)vertex.getX();
      xCoords[1] = (int)rightLeg.getX();
      xCoords[2] = (int)leftLeg.getX();
      yCoords[0] = (int)vertex.getY();
      yCoords[1]= (int)rightLeg.getY();
      yCoords[2] = (int)leftLeg.getY();
      return new Polygon(xCoords, yCoords, 3);
   }


   public void left() {
      angle += 5;
   }


   public void right() {
      angle -= 5;
   }

   public Point getVertex() {
      double x = (getPos().getX());
      double y = (getPos().getY());
      return new Point((int)(x + Math.cos(Math.toRadians(angle)) * SCALE_FACTOR),(int)( y - Math.sin((Math.toRadians(angle))) * SCALE_FACTOR));
   }

   public Point getRightLeg() {
      double x = (getPos().getX());
      double y = (getPos().getY());
      return new Point ((int)(x + Math.cos(Math.toRadians(angle - 90)) * SCALE_FACTOR / 3),(int)( y - Math.sin((Math.toRadians(angle - 90))) * SCALE_FACTOR / 3));
   }

   public Point getLeftLeg() {
      double x = (getPos().getX());
      double y = (getPos().getY());
      return new Point((int)(x + Math.cos(Math.toRadians(angle - 90)) * SCALE_FACTOR / 3),(int)( y - Math.sin((Math.toRadians(angle - 90))) * SCALE_FACTOR / 3));
   }


   public void setPoint(double x, double y) {
      pos.setPoint(x, y);
   }

   public FloatingPoint getPos() {
      return pos;
   }

   public String toString() {
      return "Position: (" + pos.getX() + ", " + pos.getY() + ")";
   }
}