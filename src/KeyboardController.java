
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
//the keyboard controller is the KeyListener of the game, it register
//all the keys currently pressed in the activeKeys HashSet
public class KeyboardController implements KeyListener{
    private static HashSet<Integer> activeKeys;
    public KeyboardController(){
        activeKeys=new HashSet<Integer>();
    }	
    public void keyPressed(KeyEvent e) {
        activeKeys.add(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {
        activeKeys.remove(e.getKeyCode());
    }
    public void keyTyped(KeyEvent e) {
    }	
    public static HashSet<Integer> getActiveKeys(){
        return activeKeys;
    }
}
