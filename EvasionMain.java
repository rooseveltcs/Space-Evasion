import java.awt.*;
import javax.swing.*;

public class EvasionMain {
   public static final FloatingPoint STARTING_POS = new FloatingPoint(1250.0, 500.0);
   
   public static void main(String[] args) {
      Rocket rocket = new Rocket(STARTING_POS, 270);
      GameBoard board = new GameBoard(rocket);
      BoardFrame frame = new BoardFrame(board);
      while (!board.isCrashed()) {
          board.repaint();
          try {
              Thread.sleep(10);
          } catch (InterruptedException exception) {
          }
          rocket.move(1);
      }
      System.out.println("Were out of the loop");
      board.repaint();
   }
}