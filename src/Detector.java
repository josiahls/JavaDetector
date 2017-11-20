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

            System.out.println("Adding panel");
            shapePanel = new ShapePanel(frame);


            frame.add(shapePanel);
            frame.pack();
            frame.repaint();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);System.out.println("Added panel");
        });
    }

    public void addShape(int name, int locX,int locY,  int width, int height) {
        while (shapePanel == null) {
            System.out.println("Waiting for UI to build...");
        }
        System.out.println("Frame width / height:" + frame.getHeight() + " " + frame.getWidth());
        shapePanel.addUserShape(new UserShape(name, frame.getHeight(), frame.getWidth(), locY, locX, width, height));
        shapePanel.repaint();
    }

    @SuppressWarnings("WeakerAccess")
    public void addShape(UserShape userShape) {

        while (shapePanel == null) {
            System.out.println("Waiting for UI to build...");
        }
        System.out.println("Frame width / height:" + frame.getHeight() + " " + frame.getWidth());
        userShape.setPanelSizeX(frame.getWidth());
        userShape.setPanelSizeY(frame.getHeight());

        shapePanel.addUserShape(userShape);
        frame.repaint();
    }

    @SuppressWarnings("WeakerAccess")
    public void addShape(int name, int locX, int locY, int radius) {

        while (shapePanel == null) {
            System.out.println("Waiting for UI to build...");
        }

        //System.out.println("Frame width / height:" + frame.getHeight() + " " + frame.getWidth());
        UserShape userShape = new UserShape(name, frame.getHeight(), frame.getWidth(), locY, locX, radius);
        shapePanel.addUserShape(userShape);
        frame.repaint();
    }

    public boolean isPointInShapes(int x, int y, UserShape point) {

        for (UserShape userShape : shapePanel.getUserShapes()) {
            System.out.println("Checking isPoint");
            if (userShape.isPointInShape(x,y) && !point.equals(userShape)) {
                System.out.println("Returning true");
                return true;
            } else {
                System.out.println("Returning false");
            }
        }
        return false;
    }

    public int getLocationY(UserShape userShape) {
        for (UserShape shape : shapePanel.getUserShapes()) {
            if (shape.equals(userShape)) {
                return shape.getLocY();
            }
        }
        return -1;
    }
    public int getLocationX(UserShape userShape) {
        for (UserShape shape : shapePanel.getUserShapes()) {
            if (shape.equals(userShape)) {
                return shape.getLocX();
            }
        }
        return -1;
    }

    public boolean isShapeInShapes(UserShape userShape) {
        boolean isInShape = false;

        for (UserShape shape : shapePanel.getUserShapes()) {
            if (!shape.equals(userShape)) {

            }
        }

        return false;//shapePanel.getUserShapes().get(0).isPointInShape(x,y);
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


    public void removeShape(UserShape userShape) {
        int index = 0;
        for (UserShape shape : shapePanel.getUserShapes()) {
            if (shape.equals(userShape)) {
                shapePanel.userShapes.remove(index);
                break;
            }
            index++;
        }

        frame.repaint();

    }

    public void moveLeft(int numberOfPixels, Integer increment) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            //System.out.println("Moving Left: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                userShape.setLocX(userShape.getLocX() - increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight(),
                        userShape.getId()
                ));
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
            //System.out.println("Moving Left: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                userShape.setLocX(userShape.getLocX() + increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()
                        , userShape.getId()));
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
            //System.out.println("Moving Down: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                //System.out.println("Moving Right:locY" + userShape.getLocY());
                userShape.setLocY(userShape.getLocY() + increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()
                        , userShape.getId()));
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
            //System.out.println("Moving Down: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                //System.out.println("Moving Right:locY" + userShape.getLocY());
                userShape.setLocY(userShape.getLocY() - increment);
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()
                        , userShape.getId()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }

    }

    public void move(int x, int y) {


        ArrayList<UserShape> userShapes = new ArrayList<>();
        for (UserShape userShape : shapePanel.getUserShapes()) {
            //System.out.println("Moving ");
            userShape.setLocY(y);
            userShape.setLocX(x);
            userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                    userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight()
                    , userShape.getId()));
        }
        removeAllShapes(0.1);
        for (UserShape userShape : userShapes) {
            shapePanel.addUserShape(userShape);
        }
        frame.repaint();


    }

    public void moveLeft(int numberOfPixels, Integer increment, UserShape userShapeParam) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            //System.out.println("Moving Left: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                if (userShapeParam == null || userShape.equals(userShapeParam)) {
                    //System.out.println("Found Shape!");
                    userShape.setLocX(userShape.getLocX() - increment);
                }
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(),
                        userShape.getHeight(), userShape.getId()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }
    }

    public void moveRight(int numberOfPixels, Integer increment, UserShape userShapeParam) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            //System.out.println("Moving Left: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                if (userShapeParam == null || userShape.equals(userShapeParam)) {
                    //System.out.println("Found Shape!");
                    userShape.setLocX(userShape.getLocX() + increment);
                }
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight(), userShape.getId()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }
    }

    public void moveDown(int numberOfPixels, Integer increment, UserShape userShapeParam) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            //System.out.println("Moving Down: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                //System.out.println("Shape being tested: " + userShape.toString() + " against: " + userShapeParam.toString());
                if (userShapeParam == null || userShape.equals(userShapeParam)) {
                    //System.out.println("Found Shape!");
                    //System.out.println("Moving Down:locY" + userShape.getLocY());
                    userShape.setLocY(userShape.getLocY() + increment);
                }
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight(), userShape.getId()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }
    }
    public void moveUp(int numberOfPixels, Integer increment, UserShape userShapeParam) {
        if (increment == null) {
            increment = 1;
        }

        for (int n = 0; n < numberOfPixels; n += increment) {
            //System.out.println("Moving Down: " + n);
            ArrayList<UserShape> userShapes = new ArrayList<>();
            for (UserShape userShape : shapePanel.getUserShapes()) {
                if (userShapeParam == null || userShape.equals(userShapeParam)) {
                    //System.out.println("Found Shape!");
                    //System.out.println("Moving Down:locY" + userShape.getLocY());
                    userShape.setLocY(userShape.getLocY() - increment);
                }
                userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                        userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight(), userShape.getId()));
            }
            removeAllShapes(0.1);
            for (UserShape userShape : userShapes) {
                shapePanel.addUserShape(userShape);
            }
            frame.repaint();
        }

    }

    public void move(int x, int y, UserShape userShapeParam) {


        ArrayList<UserShape> userShapes = new ArrayList<>();
        for (UserShape userShape : shapePanel.getUserShapes()) {
            if (userShapeParam == null || userShape.equals(userShapeParam)) {
                //System.out.println("Moving ");
                //System.out.println("Found Shape!");
                userShape.setLocY(y);
                userShape.setLocX(x);
            }
            userShapes.add(new UserShape(userShape.getName(), frame.getHeight(), frame.getWidth(),
                    userShape.getLocY(), userShape.getLocX(), userShape.getWidth(), userShape.getHeight(), userShape.getId()));
        }
        removeAllShapes(0.1);
        for (UserShape userShape : userShapes) {
            shapePanel.addUserShape(userShape);
        }
        frame.repaint();


    }
}
