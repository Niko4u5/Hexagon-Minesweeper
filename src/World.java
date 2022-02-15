import javax.swing.*;
import java.awt.*;

/**
 * contains all the tiles and manages aces to them.
 */
public class World {
    Tile[] tiles;
    int sizeX, sizeY;
    int numbers; // number of tiles that need to be clicked.

    MyCanvas window;
    World(int x, int y,MyCanvas window){
        sizeX = x;
        sizeY = y;
        this.window = window;
        //TODO: create tiles.
        //TODO: set numbers.
    }

    public void paint(Graphics g){
        for (Tile tile: tiles) {
            tile.paint(g);
        }
    }

    public void gameOver(){
        //TODO
        System.out.println("You lost");
    }

    public void repaint(){
        window.repaint();
    }
}
