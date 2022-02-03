import java.awt.*;
import javax.swing.*;
public class Bullet {
    int x, y;//-- Controls the CURRENT location of THIS bullet
    //Each object of this class is a new BULLET
    Image img;
    boolean visible; //sets weather THIS bullet is visible or not
    
    public Rectangle getBounds()
    {
       return new Rectangle(x,y,80,37);  
    }
    
    public int getX() {
        return x;
    }

    public boolean getVisible() {
        return visible;
    }
	
    public int getY() {
        return y;
    }
	
    public Image getImage() {
        return img;
    }
	
    public Bullet(int startX, int startY) {
        ImageIcon newBullet = new ImageIcon("src/img/bullet.png");
        img = newBullet.getImage();
        x = startX;
        y = startY;
        visible = true;
    }
    //Just like the move class in Player class...
    public void move() {
        x = x + 10; //x + bullet speed
        if (x > 1366)// if x > board width
            visible = false; //Make the bullet invisible
    }
}