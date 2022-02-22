import java.awt.*;
import java.awt.event.*;

public abstract class Tile {
    static final Image img = MyCanvas.loadImage("Leer.png");
    static final Image imgFlag = MyCanvas.loadImage("Flagge.png");

    final World world;
    final Polygon hexagon;
    boolean flagged, revealed;
    /**
     * Converts array to display position.
     * @param posX X position in world array
     * @param posY Y position in world array
     * @param window needed to register onClick
     */
    public Tile(int posX, int posY, MyCanvas window, World world) {
        this.world = world;
        int spacing = 25;
        int tileSize = 25;

        // Converts array to display position.
        int width = (int)(Math.sqrt(3) * spacing / 2);
        int height = spacing;
        int X = posX * width * 2;
        int Y = posY * height * 2 + posX * height;

        // Calculate hexagon size.
        hexagon = new Polygon();
        width = (int)(Math.sqrt(3) * tileSize / 2);
        height = tileSize;

        hexagon.addPoint(X - height/2, Y + width);
        hexagon.addPoint(X + height/2, Y + width);
        hexagon.addPoint(X + height, Y);
        hexagon.addPoint(X + height/2, Y - width);
        hexagon.addPoint(X - height/2, Y - width);
        hexagon.addPoint(X - height, Y);


        // Add onClick listener.
        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(hexagon.contains(e.getPoint())){
                    if((e.getButton() == 1) && !flagged){
                        onClick();
                    }else if (e.getButton() == 3){
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
