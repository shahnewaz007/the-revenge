import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class HighScore extends JPanel{
    Board b = new Board();
    Image img;
    static Font font = new Font("Comic Sans MS", Font.BOLD, 48);
    public HighScore() {
        ImageIcon i = new ImageIcon("src/img/Menu/HallOfFame .jpg");
        img = i.getImage();    
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, null);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString("[Highscore]: " +b.highscore, 350,400);
    }
}
