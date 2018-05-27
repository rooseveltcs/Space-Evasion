import java.awt.*;

public abstract class MovingObject {
   private FloatingPoint pos;

   
   public MovingObject(FloatingPoint p) {
      pos = p;
   }
   



   
   
   public void setPoint(double x, double y) {
      pos.setPoint(x, y);
   }

   public FloatingPoint getPos() {
      return pos;
   }


   
   public String toString() {
      return "Position: (" + pos.getX() + ", ";
   }
   
   public abstract void draw(Graphics g);
}
