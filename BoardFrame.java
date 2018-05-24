import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JFrame {
   public static final Color BACKGROUND = Color.BLACK;
   
   public void createBoard() {
      setSize(1000,1500);
      setContentPane(new GameBoard());
      setVisible(true);      
   }
}