import java.util.*;
import java.io.*;
import java.awt.*;

public class ScoreBoard {
    private TreeSet<Score> scores;

    public ScoreBoard() throws FileNotFoundException {
        scores = new TreeSet<Score>();
        Scanner readScores = new Scanner(new File("Scoreboard.txt"));
        while (readScores.hasNext()) {
            String name = readScores.nextLine();
            double score = Double.parseDouble(readScores.nextLine());
            scores.add(new Score(name, score));
        }
    }

    public void add(String s, double d){
            scores.add(new Score(s, d));
    }

    public String[] stringSet() {
        String[] temp = new String[scores.size()];
        int index = 0;
        for (Score s: scores) {
            temp[index] = s.getName();
            index++;
        }
        return temp;
    }


    public void updateFile()  throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("ScoreBoard.txt"));
        for (Score score: scores) {
            output.println(score.getName());
            output.println(score.getScore());
        }
    }

    public void drawScores(Graphics g, int x, int y) {
        int yCoord = y;
        int rank = 1;
        int numScores = 10;
        g.drawString("Scoreboard:", x, y - 20);
        for (Score score: scores) {
            g.drawString(rank + ". " + score, x, yCoord);
            yCoord += 20;
            rank++;
            numScores--;
            if (numScores == 0) {
                break;
            }
        }
    }

    public String toString() {
        int rank = 1;
        String temp = "";
        for (Score score: scores) {
            temp += rank + ". " + score + "\n";
            rank++;
        }
        return temp;
    }

}
