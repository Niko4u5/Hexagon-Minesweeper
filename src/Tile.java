import java.awt.*;
import java.awt.event.*;

public abstract class Tile {
    static final Image img = MyCanvas.loadImage("Unaufgedeckt.png");
    static final Image imgFlag = MyCanvas.loadImage("Flagge.png");

    final World world;
    final Polygon h;
    Polygon hexagon;
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
        int X = (int)(posX * (Math.sqrt(3) * spacing / 2) * 2);
        int Y = posY * spacing * 2 + posX * spacing;

        // Calculate hexagon size.
        h = new Polygon();
        int width = (int)(Math.sqrt(3) * tileSize / 2);
        int height = tileSize;

        h.addPoint(X - height/2, Y + width);
        h.addPoint(X + height/2, Y + width);
        h.addPoint(X + height, Y);
        h.addPoint(X + height/2, Y - width);
        h.addPoint(X - height/2, Y - width);
        h.addPoint(X - height, Y);

        hexagon = new Polygon();
        // Add onClick listener.
        MouseListener l = new MouseListener() {
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
        };
        world.listeners.add(l);
        window.addMouseListener(l);
    }

    public void paint(Graphics g){
        hexagon = new Polygon(h.xpoints,h.ypoints,h.npoints);
        hexagon.translate(world.window.getWidth()/2,world.window.getHeight()/2);
    }

    abstract public void onClick();
    public void onRightClick(){
        flagged = !flagged;
        world.repaint();
    }
}
