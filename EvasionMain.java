import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class EvasionMain {

   
   public static void main(String[] args) throws InterruptedException, FileNotFoundException {
      StartBoard startBoard = new StartBoard();
      BoardFrame frame = new BoardFrame(startBoard);
      frame.addButton(startBoard.getButton());
      boolean started = startBoard.isStarted();
      while (!started) {
          Thread.sleep(1);
          started = startBoard.isStarted();
      }
      ScoreBoard scoreBoard = new ScoreBoard();
      GameBoard board = new GameBoard();
      frame.changeBoard(board);
      boolean restarted = true;
      while (restarted) {
          Thread.sleep(1000);
          board.playGame();
          System.out.print(board.getScore());
          EndBoard endBoard = new EndBoard(scoreBoard);
          frame.changeBoard(endBoard);
          frame.addButton(endBoard.getRestartButton());
          frame.addButton(endBoard.getEndButton());
          frame.addTextField(endBoard.getTextField());
          boolean clicked = false;
          boolean ended = false;
          while (!clicked) {
              Thread.sleep(1);
              restarted = endBoard.isRestarted();
              clicked = endBoard.isRestarted() || endBoard.isEnded();
              ended = endBoard.isEnded();
          }
          scoreBoard.add(frame.getText(), board.getScore());
          scoreBoard.updateFile();
          if (ended) {
              System.out.println("We out here");
              frame.dispose();
          }
          board = new GameBoard();
          frame.changeBoard(board);
      }
   }
}