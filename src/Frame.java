import java.awt.Toolkit;
import javax.swing.*;
public class Frame { 
    public Frame() { //this function shows the frame 
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        JFrame frame = new JFrame();
        frame.add(new Board());       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(xsize, ysize);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
