import java.awt.*;

/**
 * this Tile is the bomb when clicked it ends the Game.
 */
public class Bomb extends Tile {

    public Bomb(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void onClick() {
        revealed = true;
        world.gameOver();
        world.repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (!revealed) {
            //TODO: paint
        } else {
            //TODO: paint
        }
    }
}
