import java.awt.*;

/**
 * Goal of the Game is to click all of these, on Click they show the number of bombs next to them.
 */
public class Number extends Tile {
    int neighbors;
    public Number(int posX, int posY, MyCanvas window, World world) {
        super(posX, posY, window, world);

        number = new TextArea();
        number.setBounds(hexagon.getBounds());

        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void onClick() {

        if (!revealed){
            world.numbers--;
            if (world.numbers == 0){
                world.win();
            }
            revealed = true;
            number.setText(Integer.toString(calculateNeighbors()));
            number.setVisible(true);
            number.setSize(10,10);
            world.repaint();
        }

    }

    /**
     * @return Number of neighboring bombs.
     */
    int calculateNeighbors(){
        //TODO calculateNeighbors
        return 0;
    }

    @Override
    public void paint(Graphics g) {
        if (!revealed) {
            //TODO: make prettier
            g.setColor(Color.red);
            g.fillPolygon(hexagon);
        } else {
            //TODO: show number
            g.setColor(Color.blue);
            g.fillPolygon(hexagon);
        }
    }
}
