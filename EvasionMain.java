import java.awt.*;

public class EvasionMain {
   public static final FloatingPoint STARTING_POS = new FloatingPoint(1250.0, 500.0);
   public static void main(String[] args) {
      //Set the game board with an intro
      DrawingPanel panel = new DrawingPanel(2000,750);
      Graphics g = panel.getGraphics();
      //GameBoard.board(g);
      MovingObject rocket = new Rocket(STARTING_POS, 90);
      boolean crashed = false;
      while (!crashed) {
         rocket.move(1);
         //Take user input
         rocket.draw(g);
            
      }      
   }
}