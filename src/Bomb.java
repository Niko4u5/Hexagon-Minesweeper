import java.awt.*;

/**
 * this Tile is the bomb when clicked it ends the Game.
 */
public class Bomb extends Tile {
    //TODO: add proper images
    static final Image imgBomb = MyCanvas.loadImage("src.png");

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
