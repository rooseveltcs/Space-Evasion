import java.awt.*;

public class MovingObject {
   private Point pos;
   private int angle;
   
   public MovingObject(Point p, int angle) {
      pos = p;
      this.angle = angle;
   }

   public void move(int move) {
      double x = (Math.cos(Math.toRadians(angle)) * move + pos.getX());
      double y = (Math.sin(Math.toRadians(angle)) * move + pos.getY());
      pos = new Point(x, y);
   }
   
   public void rotateObject(Angle a) {   
   }
   
   public void setObject(Point p, int deg) {
      pos = p;
      angle = deg;
   }
   
   public void changeAngle(int deg) {
      angle = deg;
   }
   
   public void drawObject(Graphics g, Point p, int a) {
   }
   
   public String toString() {
      return "Position: (" + pos.getX() + ", " + pos.getY() + ")\n" + "Angle: " + angle;
   }
}