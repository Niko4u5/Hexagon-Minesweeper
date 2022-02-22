import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        repaint();
    }

    public void paint(Graphics g) {
        this.setBackground(Color.GREEN);
        super.paint(g);
        world.paint(g);

    }

    static BufferedImage loadImage(String fileName)
    {
        BufferedImage bi = null;
        //System.err.println("....setimg...." + fileName);

        try {
            bi = ImageIO.read(new File(fileName));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image could not be read");
            System.exit(1);
        }

        return bi;
    }
}

