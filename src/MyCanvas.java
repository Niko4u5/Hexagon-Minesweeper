import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Creates a Window, draws the current scene and enables onClick methods.
 */
class MyCanvas extends Canvas {
    static final Image icon = loadImage("6.png"); //TODO: replace icon
    Scene scene;

    public MyCanvas() {
        // create the window this Canvas is Drawn in
        JFrame window = new JFrame("HexagonMinesweeper");
        window.setIconImage(icon);
        window.add(this);
        window.setVisible(true);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * @param scene sets the world that is going to be drawn on this canvas
     */
    public void setScene(Scene scene) {
        if(this.scene != null){
            this.scene.deconstruct();
        }
        this.scene = scene;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        scene.paint(g);
    }

    static BufferedImage loadImage(String fileName) {
        BufferedImage bi = null;

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
