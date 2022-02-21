import java.awt.*;

/**
 * Goal of the Game is to click all of these, on Click they show the number of bombs next to them.
 */
public class Number extends Tile {
    static final Image img0 = MyCanvas.loadImage("src.png");

    final int posX;
    final int posY;

    public Number(int posX, int posY, MyCanvas window, World world) {
        super(posX, posY, window, world);

        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Gets called when this hexagon gets clicked.
     */
    @Override
    public void onClick() {
        if (!revealed){
            world.numbers--;
            if (world.numbers == 0){
                world.win();
            }
            revealed = true;
            calculateNeighbors();

            world.repaint();
        }

    }

    /**
     * Returns number of neighboring bombs and reveals neighbors when there are no bombs.
     * @return Number of neighboring bombs.
     */
    int calculateNeighbors(){
        int i = 0;
        try { //TODO: better way of avoiding out of bounds exceptions
            if (world.tiles[posX+1][posY] instanceof Bomb) {
                i++;
            }
            if (world.tiles[posX+1][posY-1] instanceof Bomb) {
                i++;
            }
            if (world.tiles[posX][posY-1] instanceof Bomb) {
                i++;
            }
            if (world.tiles[posX-1][posY] instanceof Bomb) {
                i++;
            }
            if (world.tiles[posX-1][posY+1] instanceof Bomb) {
                i++;
            }
            if (world.tiles[posX][posY+1] instanceof Bomb) {
                i++;
            }
            if(i == 0){
                world.tiles[posX+1][posY].onClick();
                world.tiles[posX+1][posY-1].onClick();
                world.tiles[posX][posY-1].onClick();
                world.tiles[posX-1][posY].onClick();
                world.tiles[posX-1][posY+1].onClick();
                world.tiles[posX][posY+1].onClick();
            }
        } catch (ArrayIndexOutOfBoundsException e){}


        return i;
    }

    @Override
    public void paint(Graphics g) {
        if (!revealed) {
            //TODO: make prettier
            //TODO: show flags
            g.setColor(Color.red);
            g.fillPolygon(hexagon);
        } else {
            //TODO: show number
            g.setColor(Color.blue);
            g.fillPolygon(hexagon);
        }
    }
}
