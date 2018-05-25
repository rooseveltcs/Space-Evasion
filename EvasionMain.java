import java.awt.*;
import javax.swing.*;

public class EvasionMain {
   public static final FloatingPoint STARTING_POS = new FloatingPoint(1250.0, 500.0);
   
   public static void main(String[] args) {
      Rocket rocket = new Rocket(STARTING_POS, 90);
      GameBoard board = new GameBoard(rocket);
      BoardFrame frame = new BoardFrame(board);           
   }
}