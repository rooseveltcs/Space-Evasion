import javax.swing.*;

public class Frame extends JFrame {

   public void create() {
      setSize(500,500);
      setContentPane(new GameBoard());
      setVisible(true);
   }      
}