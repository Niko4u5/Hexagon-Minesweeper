import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public abstract class Scene {
    MyCanvas window;
    List<MouseListener> listeners;
    Scene(MyCanvas window){
        listeners = new ArrayList<>();
        this.window = window;
    }
    public abstract void paint(Graphics g);
    void deconstruct(){
        for (MouseListener l:listeners) {
            window.removeMouseListener(l);
        }
    }
}
