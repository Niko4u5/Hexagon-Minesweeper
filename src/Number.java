import javax.swing.*;
import java.awt.*;

/**
 * Goal of the Game is to click all of these, on Click they show the number of bombs next to them.
 */
public class Number extends Tile {
    int neighbors;
    public Number(int posX, int posY, MyCanvas window, World world) {
        super(posX, posY, window, world);
        // sets the coordinates of the hexagon
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
            //TODO: make prettier
            g.setColor(Color.red);
            g.fillPolygon(hexagon);
        } else {
            g.setColor(Color.blue);
            g.fillPolygon(hexagon);
        }
    }
}
