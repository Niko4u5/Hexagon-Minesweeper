import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Start extends Scene{
    /*TODO: show start screen with:
            - difficulty settings
         */

    Start(MyCanvas window){
        super(window);
        MouseListener l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.setScene(new World(10,10, window));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }};
        listeners.add(l);
        window.addMouseListener(l);
    }

    @Override
    public void paint(Graphics g) {

    }
}
