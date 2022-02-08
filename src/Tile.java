import java.awt.*;

public abstract class Tile {
    int posX, posY;
    World world;
    boolean flagged, revealed;
    /**
     * Converts array to display position.
     * @param posX X position in world array
     * @param posY Y position in world array
     */
    public Tile(int posX, int posY) {
        //TODO: Converts array to display position.
        this.posX = posX;
        this.posY = posY;

        //TODO: register onClick / onRightClick
    }

    abstract public void paint(Graphics g);

    abstract public void onClick();
    public void onRightClick(){
        flagged = !flagged;
        world.repaint();
    }
}