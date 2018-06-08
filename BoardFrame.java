import com.sun.tools.javadoc.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardFrame extends JFrame implements KeyListener,ActionListener {
   private static final Color BACKGROUND = Color.BLACK;
   public static final Dimension DIMENSION = new Dimension(1500, 800);
   private JPanel board;
   private JTextField textField;
   
   public BoardFrame(JPanel board) {
      this.board = board;
      setSize(DIMENSION);
      setBackground(BACKGROUND);
      setResizable(false);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setContentPane(board);
      addKeyListener(this);
      setVisible(true);      
   }

   public void addButton(JButton b) {
      if (b != null) {
         b.addActionListener(this);
      }
   }

   public void addTextField(JTextField j) {
      if (j != null) {
         j.addActionListener(this);
         textField = j;
      }
   }

   public String getText() {
      if (board instanceof EndBoard) {
         return textField.getText();
      } else {
         return null;
      }
   }

   public void changeBoard(JPanel p) {
      remove(board);

      board = p;
      setContentPane(board);
      requestFocus();
   }

   public void actionPerformed(ActionEvent e) {
      if (board instanceof StartBoard) {
         if (e.getActionCommand().equals("start")) {
            System.out.println("Game started!");
            ((StartBoard) board).changeStart(true);
         }
      } else if (board instanceof EndBoard) {
         if (e.getActionCommand().equals("restart")) {
            System.out.println("Game restarted!");
            ((EndBoard) board).changeRestarted(true);
         }
         if (e.getActionCommand().equals("text inputted")) {
            System.out.println("Text inputted!");
            //((EndBoard) board)
         }
         if (e.getActionCommand().equals("end")) {
            System.out.println("Game Ended");
            ((EndBoard) board).changeEnded(true);
         }
      }
   }

   
   public void keyPressed(KeyEvent k) {
      if (board instanceof GameBoard) {
         int keyCode = k.getKeyCode();
         if (keyCode == KeyEvent.VK_LEFT) {
            ((GameBoard) board).turnRocket(1);
         }
         if (keyCode == KeyEvent.VK_RIGHT) {
            ((GameBoard) board).turnRocket(-1);
         }
      }
   }
   
   public void keyReleased(KeyEvent k) {
      //Not used
   }
   
   public void keyTyped(KeyEvent k) {
      //Not used
   }
}