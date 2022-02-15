import javax.swing.*;
import java.awt.*;

/**
 * this Tile is the bomb when clicked it ends the Game.
 */
public class Bomb extends Tile {

    public Bomb(int posX, int posY, MyCanvas window, World world) {
        super(posX, posY, window, world);
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
            //TODO: make prettier
            g.setColor(Color.red);
            g.fillPolygon(hexagon);
        } else {
            g.setColor(Color.orange);
            g.fillPolygon(hexagon);
        }
    }
}
