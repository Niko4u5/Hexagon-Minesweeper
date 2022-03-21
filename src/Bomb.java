import java.awt.*;

/**
 * this Tile is the bomb when clicked it ends the Game.
 */
public class Bomb extends Tile {
    static final Image imgBomb = MyCanvas.loadImage("Bombe.png");

    public Bomb(int posX, int posY, MyCanvas window, World world) {
        super(posX, posY, window, world);
    }

    @Override
    public void onClick() {
        //TODO: first click no bomb
        revealed = true;
        world.gameOver();
        world.repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (!revealed) {
            if(flagged){
                g.drawImage(imgFlag,hexagon.getBounds().x,hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height,null);
            }else {
                g.drawImage(img,hexagon.getBounds().x,hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height,null);
            }
        } else {
            g.drawImage(imgBomb,hexagon.getBounds().x,hexagon.getBounds().y,
                    hexagon.getBounds().width, hexagon.getBounds().height,null);
        }
    }
}
