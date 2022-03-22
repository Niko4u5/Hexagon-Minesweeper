import java.awt.*;

/**
 * Goal of the Game is to click all of these, on Click they show the number of bombs next to them.
 */
public class Number extends Tile {
    static final Image img0 = MyCanvas.loadImage("Leer 1.png");
    static final Image img1 = MyCanvas.loadImage("1.png");
    static final Image img2 = MyCanvas.loadImage("2.png");
    static final Image img3 = MyCanvas.loadImage("3.png");
    static final Image img4 = MyCanvas.loadImage("4.png");
    static final Image img5 = MyCanvas.loadImage("5.png");
    static final Image img6 = MyCanvas.loadImage("1.png"); //TODO: Image missing


    final int posX;
    final int posY;
    int neighbours;

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
            neighbours = calculateNeighbors();
            world.repaint();
        }

    }

    /**
     * Returns number of neighboring bombs and reveals neighbors when there are no bombs.
     * @return Number of neighboring bombs.
     */
    int calculateNeighbors(){
        int i = 0;
        if (world.getTile(posX+1,posY) instanceof Bomb) {
            i++;
        }
        if (world.getTile(posX+1,posY-1) instanceof Bomb) {
            i++;
        }
        if (world.getTile(posX,posY-1) instanceof Bomb) {
            i++;
        }
        if (world.getTile(posX-1,posY) instanceof Bomb) {
            i++;
        }
        if (world.getTile(posX-1,posY+1) instanceof Bomb) {
            i++;
        }
        if (world.getTile(posX,posY+1) instanceof Bomb) {
            i++;
        }
        if(i == 0){
            world.getTile(posX+1,posY).onClick();
            world.getTile(posX+1,posY-1).onClick();
            world.getTile(posX,posY-1).onClick();
            world.getTile(posX-1,posY).onClick();
            world.getTile(posX-1,posY+1).onClick();
            world.getTile(posX,posY+1).onClick();
        }


        return i;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (!revealed) {
            if(flagged){
                g.drawImage(imgFlag,hexagon.getBounds().x,hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height,null);
            }else {
                g.drawImage(img,hexagon.getBounds().x,hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height,null);
            }
        } else {
            switch (neighbours) {
                case 0 -> g.drawImage(img0,hexagon.getBounds().x,hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height,null);
                case 1 -> g.drawImage(img1, hexagon.getBounds().x, hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height, null);
                case 2 -> g.drawImage(img2, hexagon.getBounds().x, hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height, null);
                case 3 -> g.drawImage(img3, hexagon.getBounds().x, hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height, null);
                case 4 -> g.drawImage(img4, hexagon.getBounds().x, hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height, null);
                case 5 -> g.drawImage(img5, hexagon.getBounds().x, hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height, null);
                case 6 -> g.drawImage(img6, hexagon.getBounds().x, hexagon.getBounds().y,
                        hexagon.getBounds().width, hexagon.getBounds().height, null);
            }
        }
    }
}
