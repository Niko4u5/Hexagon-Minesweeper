import java.awt.*;

/**
 * Goal of the Game is to click all of these, on Click they show the number of bombs next to them.
 */
public class Number extends Tile {
    int neighbors;
    private Polygon hexagon;
    public Number(int posX, int posY) {
        super(posX, posY);
        // sets the coordinates of the hexagon
        hexagon = new Polygon();
        int tileSize = 10;
        posX = posX * 21;
        posY = posY * 21 + posX / 2;
        hexagon.addPoint(posX - tileSize/2, posY + tileSize);
        hexagon.addPoint(posX + tileSize/2, posY + tileSize);
        hexagon.addPoint(posX + tileSize, posY);
        hexagon.addPoint(posX + tileSize/2, posY - tileSize);
        hexagon.addPoint(posX - tileSize/2, posY - tileSize);
        hexagon.addPoint(posX - tileSize, posY);

    }

    @Override
    public void onClick() {
        revealed = true;
        neighbors = calculateNeighbors();
        world.repaint();
    }

    /**
     * @return Number of neighboring bombs.
     */
    int calculateNeighbors(){
        //TODO calculateNeighbors
        return 0;
    }

    @Override
    public void paint(Graphics g) {
        if (!revealed) {
            g.fillPolygon(hexagon);
        } else {
            //TODO paint
        }
    }
}
