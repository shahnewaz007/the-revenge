import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*; 

public class Player {
    Board b;
    int x, dx, y, nx2, left, dy, index = 0;
    double HIndex=0.0;
    Image still;
    Image john[] = new Image[7];
	
    int ammo = 20;
    static ArrayList bullets;//Holds number of bullets on screen
    	
    ImageIcon j= new ImageIcon("src/img/Jump/1.png");
	
    public static ArrayList getBullets() {
        return bullets;
    }
    public Player() {
        john[0] = (new ImageIcon("src/img/Run/1.png").getImage());
        john[1] = (new ImageIcon("src/img/Run/2.png").getImage());
        john[2] = (new ImageIcon("src/img/Run/3.png").getImage());
        john[3] = (new ImageIcon("src/img/Run/4.png").getImage());
        john[4] = (new ImageIcon("src/img/Run/5.png").getImage());
        john[5] = (new ImageIcon("src/img/Run/6.png").getImage());
        john[6] = (new ImageIcon("src/img/Run/7.png").getImage());
        
        x = 75;
        left = 150;
        nx2= 1361;
        y = 450;
        bullets = new ArrayList();	
    }
	
    public void fire() { //Method to run when when fired
        if (ammo > 0){
            ammo--;		
            Bullet z = new Bullet((left + 145), (y + 130/2)); //Create a new bullet object and add it to array "list" of all bullets on screen.
            bullets.add(z);
        }
    }

    public void move() {
        /*if(left > 0){
            if (left + dx > 150){
                x = x + dx;
                nx2= nx2+dx;
            }
            if (left+dx > 0 && left+dx < 150){
                left = left + dx;
            }
        }else{
            left = 0;
        }*/
        if(left > 0) {
            if (left + dx <= 150)
                    left+=dx;
            else{
                x = x + dx;
                nx2= nx2+dx;
            }
        }
        else {
            left = 0;
            left+=dx;
	}
    }
    
    public Rectangle getBounds()
    {
       return new Rectangle(left,y,200,200);  
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    	
    public int getnX2() {
        return nx2;
    }
    
    public int getLeft(){
        return left;
    }
    public int getdx() {
        return dx;
    }
	
    public Image getImage() {
        return still = john[index];
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {		
            dx = -3;
            if(index==0){
                index=6;
            }
            index--;
        }
	if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            HIndex = HIndex+.5;
            System.out.println(HIndex);
            if(HIndex>6){
                HIndex=0;
            }
            
            if(HIndex==0.00 || HIndex==1.00 || HIndex==2.00 ||  HIndex==3.00 || HIndex==4.00 || HIndex==5.00 || HIndex==6.00){
                index=(int) HIndex;
               
              
            }  
        }
	if (key == KeyEvent.VK_F) {
            fire();
        }
	if (key == KeyEvent.VK_UP) {
            dy = 1;
            still = j.getImage();
        }
        if (key == KeyEvent.VK_ESCAPE){
             b.pause();
        } 
        
        
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
                dx = 0;

        if (key == KeyEvent.VK_RIGHT)
                dx = 0;
                index=6;
		
        if (key == KeyEvent.VK_UP) {
            dy = 0;
            index = 0;
        } 
        if (key == KeyEvent.VK_ESCAPE) {
             new PausePage().setVisible(true);
        }
    }
}