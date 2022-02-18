import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MyCanvas canvas = new MyCanvas();
        World world = new World(7,7, canvas);
        canvas.setWorld(world);
    }
}

/**
 *  Creates a Window, draws the world and enables onClick methods.
 */
class MyCanvas extends Canvas {
    World world;
    public MyCanvas() {
        JFrame window = new JFrame("Example");
        window.add(this);
        window.setVisible(true);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * @param world sets the world that is going to be drawn on this canvas
     */
    public void setWorld(World world) {
        this.world = world;
    }

    public void paint(Graphics g) {
        this.setBackground(Color.GREEN);
        super.paint(g);
        world.paint(g);

    }
}

