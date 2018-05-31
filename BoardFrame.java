import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardFrame extends JFrame implements KeyListener {
   private static final Color BACKGROUND = Color.BLACK;
   private GameBoard board;
   
   public BoardFrame(GameBoard board) {
      this.board = board;
      setSize(1000,500);
      setBackground(BACKGROUND);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setContentPane(board);
      addKeyListener(this);
      setVisible(true);      
   }
   
   public void keyPressed(KeyEvent k) {
      int keyCode = k.getKeyCode();
      if (keyCode == KeyEvent.VK_LEFT) {
         System.out.println("Pressed Left");
         board.turnRocket(1);
      }
      if (keyCode == KeyEvent.VK_RIGHT) {
         System.out.println("Pressed right");
         board.turnRocket(-1);
      }
   }
   
   public void keyReleased(KeyEvent k) {
      //Not used
   }
   
   public void keyTyped(KeyEvent k) {
      //Not used
   }
}