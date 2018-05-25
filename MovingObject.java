import java.awt.*;

public abstract class MovingObject {
   private FloatingPoint pos;
   private int angle;
   
   public MovingObject(FloatingPoint p, int angle) {
      pos = p;
      this.angle = angle;
   }
   
   public void left() {
      angle++;
   }
   
   public void right() {
      angle--;
   }

   public void move(int move) {
      double x = (Math.cos(Math.toRadians(angle)) * move + pos.getX());
      double y = (-Math.sin(Math.toRadians(angle)) * move + pos.getY());
      pos.setPoint(x, y);
   }
   
   
   public void setObject(FloatingPoint p, int deg) {
      pos = p;
      angle = deg;
   }

   public FloatingPoint getPos() {
      return pos;
   }

   public int getAngle() {
        return angle;
   }
   
   public void changeAngle(int deg) {
      angle = deg;
   }
   
   public String toString() {
      return "Position: (" + pos.getX() + ", " + pos.getY() + ")\n" + "Angle: " + angle;
   }
   
   public abstract void draw(Graphics g);
}
