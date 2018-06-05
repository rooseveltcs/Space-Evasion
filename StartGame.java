public class StartGame extends JPanel {
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      g.setBackground(Color.BLACK);
      g.setColor(Color.WHITE);
      //some circle stars
      for(int i = 1; i <= 25; i++){
         g.drawOval(Math.random(), Math.random(), 5, 5);
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
}  