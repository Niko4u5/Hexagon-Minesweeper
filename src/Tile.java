import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Tile {
    World world;
    MyCanvas window;
    Polygon hexagon;
    JButton button;
    boolean flagged, revealed;
    /**
     * Converts array to display position.
     * @param posX X position in world array
     * @param posY Y position in world array
     * @param window needed to register onClick
     */
    public Tile(int posX, int posY, MyCanvas window, World world) {
        this.world = world;
        this.window = window;
        // Converts array to display position.
        int spacing = 50;
        int w = (int)(Math.sqrt(3) * spacing / 2);
        int h = spacing;

        int X = posX * w * 2;
        int Y = posY * h * 2 + posX * h;

        hexagon = new Polygon();
        int tileSize = 40;
        w = (int)(Math.sqrt(3) * tileSize / 2);
        h = tileSize;

        hexagon.addPoint(X - h/2, Y + w);
        hexagon.addPoint(X + h/2, Y + w);
        hexagon.addPoint(X + h, Y);
        hexagon.addPoint(X + h/2, Y - w);
        hexagon.addPoint(X - h/2, Y - w);
        hexagon.addPoint(X - h, Y);

        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(hexagon.contains(e.getPoint())){
                    if(e.getButton() == 1){
                        onClick();
                    }else if (e.getButton() == 2){
                        onRightClick();
                    }
                }
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

            }
        });
    }

    abstract public void paint(Graphics g);

    abstract public void onClick();
    public void onRightClick(){
        flagged = !flagged;
        world.repaint();
    }
}
