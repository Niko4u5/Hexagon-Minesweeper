import javax.swing.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Main {
    public static void main(String[] args) {
        World world = new World(5,5);

        JFrame window = new JFrame("Example");
        MyCanvas canvas = new MyCanvas(world);
        window.add(canvas);
        window.setVisible(true);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(3);
    }
}

class MyCanvas extends Canvas {
    World world;
    public MyCanvas(World world) {
        this.world = world;
        this.setBackground(Color.GREEN);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        world.paint(g);

    }
}

