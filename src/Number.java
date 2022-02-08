import java.awt.*;

/**
 * Goal of the Game is to click all of these, on Click they show the number of bombs next to them.
 */
public class Number extends Tile {
    int neighbors;

    public Number(int posX, int posY) {
        super(posX, posY);
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
            //TODO paint
        } else {
            //TODO paint
        }
    }
}
