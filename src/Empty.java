import java.awt.*;
/**
 * this tile is used to fill space in the world array which aren't part of the game.
 * it can't be clicked and is not visible.
 */
public class Empty extends Tile {

    public Empty(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void onClick() { }

    @Override
    public void onRightClick() { }

    @Override
    public void paint(Graphics g) { }

}
