import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Example");

        MyCanvas canvas = new MyCanvas();
        World world = new World(5,5, canvas);
        canvas.setWorld(world);
        window.add(canvas);
        window.setVisible(true);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class MyCanvas extends Canvas {
    World world;
    public MyCanvas() {
        this.setBackground(Color.GREEN);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        world.paint(g);

    }
}

