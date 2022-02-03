import java.awt.*;
import javax.swing.ImageIcon;
public class Enemy {
    Image img;
    int x,y;
    boolean isAlive=true;
    
    public Enemy(int startX , int startY , String location) {
        x=startX;
        y=startY;
        
        ImageIcon l= new ImageIcon(location);
        img=l.getImage();   
    }
    
    public Rectangle getBounds() {
       return new Rectangle(x,y,280,280);  
    }
    
    public int getX() {
        return x;
    }
     
    public int getY() {
        return y;
    }
    
    public boolean Alive() {
        return isAlive;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void move(int dx) {
        x = x-dx;
    }     
}