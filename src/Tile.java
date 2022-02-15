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
        posX = posX * 21;
        posY = posY * 21 + posX / 2;

        hexagon = new Polygon();
        int tileSize = 10;

        hexagon.addPoint(posX - tileSize/2, posY + tileSize);
        hexagon.addPoint(posX + tileSize/2, posY + tileSize);
        hexagon.addPoint(posX + tileSize, posY);
        hexagon.addPoint(posX + tileSize/2, posY - tileSize);
        hexagon.addPoint(posX - tileSize/2, posY - tileSize);
        hexagon.addPoint(posX - tileSize, posY);

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
