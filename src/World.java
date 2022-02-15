import java.awt.*;

/**
 * contains all the tiles and manages aces to them.
 */
public class World {
    Tile[][] tiles;
    int sizeX, sizeY;
    int numbers; // number of tiles that need to be clicked.

    MyCanvas window;
    World(int x, int y,MyCanvas window){
        sizeX = x;
        sizeY = y;
        tiles = new Tile[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                tiles[i][j] = new Number(i,j,window,this);
            }
        }
        int bombs = 5;
        while (bombs > 0){
            int i = (int)(Math.random() * sizeX);
            int j = (int)(Math.random() * sizeY);

            if (tiles[i][j] instanceof Bomb){
                return;
            } else {
                tiles[i][j] = new Bomb(i,j,window,this);
            }
        }
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
