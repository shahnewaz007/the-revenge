import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Board extends JPanel implements ActionListener, Runnable {
    Player p;
    public Image img;
    Timer time;
    int v = 460;
    int score=0;
    Thread animator;
    Enemy en;
    Enemy en2;
   
    boolean lost = false;

    static Font font = new Font("SanSerif", Font.BOLD, 24);

    boolean a = false;
    boolean done2 = false;

    public Board() {
        p = new Player();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("src/img/Background.jpg");
        img = i.getImage();
        time = new Timer(15, this);
        time.start();
        en = new Enemy(1300, 460, "src/img/enemy.png");
        en2 = new Enemy(1400, 460, "src/img/enemy.png");
    }

    public void pause() {
        time.stop();
    }

    public void resume() {
        time.start();
    }

    public void checkcollitions() {
        Rectangle r1 = en.getBounds();
        Rectangle r2 = en2.getBounds();

        ArrayList bullets = Player.getBullets();

        for (int i = 0; i < bullets.size(); i++) {
            Bullet m = (Bullet) bullets.get(i);
            Rectangle m1 = m.getBounds();
            if (r1.intersects(m1) && en.Alive()) {
                en.isAlive = false;
                m.visible = false;
                score++;
            } else if (r2.intersects(m1) && en2.Alive()) {
                en2.isAlive = false;
                m.visible = false;
                score++;
            }

        }
        
        Rectangle d = p.getBounds();
        
        if(d.intersects(r1) || d.intersects(r2)){
            lost=true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        checkcollitions();
        ArrayList bullets = Player.getBullets();
        for (int i = 0; i < bullets.size(); i++) {
            //This is how to get a current element in an arrayList similar to x[2] in a normal array
            Bullet m = (Bullet) bullets.get(i);//draw:
            if (m.getVisible() == true) {
                m.move();
            } else {
                bullets.remove(i);
            }
        }
        p.move();
        if (p.x > 700) {
            en.move(p.getdx());
        }

        if (p.x > 900) {
            en2.move(p.getdx());
        }
        repaint();
    }

    public void paint(Graphics g) {
        /*if (lost) {
            System.exit(0);
        }*/
        if (p.dy == 1 && done2 == false) {
            done2 = true;
            animator = new Thread(this);
            animator.start();
        }
        p.y = v;
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Get bullets from ArrayList
        g2d.drawImage(img, 1361 - p.getnX2(), 0, null);
        g2d.drawImage(p.getImage(), p.left, v, null);
        /*if (p.getdx() == -3) {
            g2d.drawImage(img, 1361 - p.getnX2(), 0, null);
            g2d.drawImage(p.getImage(), p.left, v, null);
        }*/
        ArrayList bullets = Player.getBullets(); 
        for (int i = 0; i < bullets.size(); i++) {
            //This is how to get a current element in an arrayList similar to x[2] in a normal array
            Bullet m = (Bullet) bullets.get(i);//draw:
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);
        }
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Bullet left: " + p.ammo, 1200, 50);
        g2d.drawString("Score : " + score, 600, 50);

        if (p.x > 400) {
            if (en.Alive() == true) {
                g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
            }

        }
        if (p.x > 500) {
            if (en2.Alive() == true) {
                g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
            }

        }
    }

    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
    }

    boolean h = false;
    boolean done = false;

    public void cycle() {
        if (h == false) {
            v--;
        }
        if (v == 260) {
            h = true;
        }
        if (h == true && v <= 460) {
            v++;
            if (v == 460) {
                done = true;
            }
        }
    }

    public void run() {
        while (done == false) {
            cycle();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {

            }
        }
        done = false;
        h = false;
        done2 = false;
    }
}
