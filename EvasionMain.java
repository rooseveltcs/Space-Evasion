import java.awt.*;
import javax.swing.*;

public class EvasionMain {

   
   public static void main(String[] args) {
      Rocket rocket = new Rocket();
      GameBoard board = new GameBoard(rocket);
      BoardFrame frame = new BoardFrame(board);
      while (!board.isCrashed()) {
          board.repaint();
          try {
              Thread.sleep(10);
          } catch (InterruptedException exception) {
          }
          rocket.move(2);
      }
      System.out.println("Were out of the loop");
      board.repaint();
   }
}