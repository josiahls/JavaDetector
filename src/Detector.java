import javax.swing.*;
import java.awt.*;

/**
 * @author Josiah Laivins
 *
 * @version 1.0 10/17/2017
 *
 *
 * 
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Detector {

    private JFrame frame;
    private ShapePanel shapePanel;

    public static final int TRIANGLE = 0;
    public static final int SQUARE = 1;
    public static final int RECTANGLE = 2;
    public static final int CIRCLE = 3;


    public Detector(String title, int width, int height) {

        EventQueue.invokeLater(() -> {
            frame = new JFrame(title);
            frame.setSize(width, height);

            shapePanel = new ShapePanel(frame);

            frame.add(shapePanel);
            frame.pack();
            frame.repaint();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public void addShape(int name, int locX,int locY,  int width, int height) {
        while (shapePanel == null) {
            System.out.println("Waiting for UI to build...");
        }

        shapePanel.addUserShape(new UserShape(name, frame.getHeight(), frame.getWidth(), locY, locX, width, height));
        shapePanel.repaint();
    }

    @SuppressWarnings("WeakerAccess")
    public void addShape(int name, int locX, int locY, int radius) {

        System.out.println("Loading UI...");
        while (true) {
            if (!(shapePanel == null)) break;
        }
        System.out.println("Loading finished...");

        shapePanel.addUserShape(new UserShape(name, frame.getY(), frame.getX(), locY, locX, radius));
    }

    protected boolean isPointInShapes(int x, int y) {

        addShape(CIRCLE, x,y, 10);

        return shapePanel.getUserShapes().get(0).isPointInShape(x,y);
    }

    public void addPoint(int x, int y) {

        addShape(CIRCLE, x,y, 10);
    }

    public void addPoint(int x, int y, int radius) {

        addShape(CIRCLE, x,y, radius);
    }

    public void removeAllShapes() {
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shapePanel.removeAllShapes();
    }

    public void removeAllShapes(double secondsDelay) {
        try {
            Thread.sleep((long)(secondsDelay * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shapePanel.removeAllShapes();

    }
}
