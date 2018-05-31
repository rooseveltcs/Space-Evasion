import javax.swing.*;
import java.awt.*;

public class TestFrame {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Memesters");
      frame.setSize(500,500);
      JPanel panel = new JPanel();
      
      frame.add(panel);
      panel.setBackground(Color.GREEN);
      Graphics g = panel.getGraphics();
      g.drawLine(0,0,500,500);
      frame.setVisible(true);
   }
}