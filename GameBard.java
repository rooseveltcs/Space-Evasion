import java.awt.*;
import javax.swing.*;

public class GameBard extends JPanel {
   public void paintComponent(Graphics g) {
      System.out.println("It works!");
      super.paintComponent(g);
      g.drawLine(0,0,10,10);
   }
}