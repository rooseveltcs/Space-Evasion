import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartBoard extends JPanel{
    private boolean started;
    private JButton button;

    public StartBoard() {
        setSize(BoardFrame.DIMENSION);
        setBackground(Color.BLACK);
        started = false;
        button= new JButton("Press to Start!");
        add(button);
        button.setActionCommand("start");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        //some circle stars
        for(int i = 1; i <= 25; i++){
            g.drawOval((int) (Math.random() * BoardFrame.DIMENSION.getWidth()), (int)(Math.random() * BoardFrame.DIMENSION.getHeight()), 5, 5);
        }
        g.setColor(Color.RED);
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        g.drawString("S", 100, 200);
        g.drawString("P", 140, 185);
        g.drawString("A", 180, 170);
        g.drawString("C", 220, 155);
        g.drawString("E", 260, 140);
        g.drawString("EVASION", 180, 200);
    }


    public boolean isStarted() {
        return started;
    }

    public void changeStart(boolean a) {
        started = a;
    }

    public JButton getButton() {
        return button;
    }
}
