import java.awt.*;

public class Test {
    public static void main(String[]args) {
        DrawingPanel panel = new DrawingPanel(300, 300);
        Graphics g = panel.getGraphics();
        Rocket r = new Rocket(new FloatingPoint(50, 50), 235);
        r.draw(g);
    }
}
