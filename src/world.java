import java.awt.*;

/**
 * contains all the tiles and manages aces to them.
 */
public class world {
    tile[] tiles;
    int sizeX, sizeY;
    int numbers; // number of tiles that need to be clicked.
    world(int x,int y){
        sizeX = x;
        sizeY = y;
        tiles = new tile[sizeY*sizeY];
        //TODO: create tiles.
        //TODO: set numbers.
    }

    public void paint(Graphics g){
        for (tile tile: tiles) {
            tile.paint(g);
        }
    }

    public void gameOver(){
        //TODO
    }

    public void repaint(){
        //TODO
    }
}
