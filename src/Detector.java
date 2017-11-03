import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        frame.repaint();
    }

    public boolean isPointInShapes(int x, int y) {

        addShape(CIRCLE, x,y, 10);
        frame.repaint();

        return shapePanel.getUserShapes().get(0).isPointInShape(x,y);
    }

    public void addPoint(int x, int y) {

        addShape(CIRCLE, x,y, 10);
        frame.repaint();

    }

    public void addPoint(int x, int y, int radius) {

        addShape(CIRCLE, x,y, radius);
        frame.repaint();
    }

    public void removeAllShapes() {
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shapePanel.removeAllShapes();
        frame.repaint();
    }

    public void removeAllShapes(double secondsDelay) {
        try {
            Thread.sleep((long)(secondsDelay * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shapePanel.removeAllShapes();
        frame.repaint();

    }

    public void moveLeft(int numberOfPixels, Integer increment) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            System.out.println("Moving Left: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                userShape.setLocX(userShape.getLocX() - increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }
    }

    public void moveRight(int numberOfPixels, Integer increment) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            System.out.println("Moving Left: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                userShape.setLocX(userShape.getLocX() + increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }
    }

    public void moveDown(int numberOfPixels, Integer increment) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            System.out.println("Moving Down: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                System.out.println("Moving Right:locY" + userShape.getLocY());
                userShape.setLocY(userShape.getLocY() + increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }
    }
    public void moveUp(int numberOfPixels, Integer increment) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            System.out.println("Moving Down: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                System.out.println("Moving Right:locY" + userShape.getLocY());
                userShape.setLocY(userShape.getLocY() - increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }

    }
}
