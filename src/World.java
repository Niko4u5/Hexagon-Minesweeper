import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * contains all the tiles and manages aces to them.
 */
public class World extends Scene{
    final private Tile[][] tiles;
    final int sizeX, sizeY;
    int numbers; // number of tiles that need to be clicked.

    private boolean gameOver = false;
    static final Image imgBackground = MyCanvas.loadImage("Hintergrund_Blau.png");
    static final Image imgBackgroundGameOver = MyCanvas.loadImage("Hintergrund_Rot.png");


    final MyCanvas window;
    World(int x, int y,MyCanvas window){
        //TODO: Difficulty settings
        //TODO: place nodes in a rectangle and centered on the screen
        this.window = window;
        sizeX = x;
        sizeY = y;
        tiles = new Tile[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                tiles[i][j] = new Number(i,j,window,this);
            }
        }
        int bombs = 17;
        numbers = sizeX * sizeY - bombs;
        while (bombs > 0){
            int i = (int)(Math.random() * sizeX);
            int j = (int)(Math.random() * sizeY);

            if (!(tiles[i][j] instanceof Bomb)) {
                tiles[i][j] = new Bomb(i, j, window, this);
                bombs--;
            }
        }

        non = new Empty(0,0,window,this);
    }

    public void paint(Graphics g){
        // Show background, Blue or Red depending on Game Over state.
        if(gameOver){
            g.drawImage(imgBackgroundGameOver,0,0,window.getWidth(),window.getHeight(),null);
        }else {
            g.drawImage(imgBackground,0,0,window.getWidth(),window.getHeight(),null);

        }

        for (Tile[] tiles: tiles) {
            for (Tile tile: tiles
                 ) {
                tile.paint(g);
            }
        }
        // Set the desired font if different from default font
        Font font = new Font("Serif", Font.PLAIN, 20);
        g.setFont(font);

        // clear area for text
        g.clearRect(window.getWidth()/2-200,2,400,20);

        // Write to area
        g.drawString(Integer.toString(numbers),window.getWidth()/2-200,20);
        //TODO: Time
        //TODO: Make pretty

        // Show game over screen
        if(gameOver){
            g.clearRect(window.getWidth()/2-125,window.getHeight()/2-10,250,20);
            g.drawString("Game Over, Click to continue",window.getWidth()/2-122,window.getHeight()/2+7);
        }
    }

    public void gameOver(){
        for (Tile[] tiles: tiles) {
            for (Tile tile: tiles
            ) {
                tile.revealed = true;
            }
        }
        gameOver = true;
        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: go to start screen

                System.exit(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void win(){
        gameOver();
    }

    public void repaint(){
        window.repaint();
    }


    private final Tile non;
    public Tile getTile(int xPos, int yPos) {
        try {
            return tiles[xPos][yPos];
        }catch (ArrayIndexOutOfBoundsException e){
            return non;
        }

    }
}
