import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Josiah Laivins
 *
 * @version 1.0 10/9/2017
 *
 */
public class ShapePanel extends JPanel {

    private Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.ORANGE, Color.YELLOW};

    private JFrame context;
    private ArrayList<UserShape> userShapes;

    ShapePanel(JFrame context) {
        this.context = context;
        userShapes = new ArrayList<>();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw current list of shapes
        int index = 0;
        for (UserShape userShape : userShapes) {
            g.setColor(colors[index++]);
            switch (userShape.getName()) {
                case Detector.TRIANGLE:
                    g.drawPolygon(userShape.getPointsX(), userShape.getPointsY(), 3);
                    g.fillPolygon(userShape.getPointsX(), userShape.getPointsY(), 3);
                    break;
                case Detector.SQUARE:
                case Detector.RECTANGLE:
                    g.drawRect(userShape.getLocX()-userShape.getWidth()/2,userShape.getLocY()-userShape.getHeight()/2,
                            userShape.getWidth(), userShape.getHeight());
                    g.fillRect(userShape.getLocX()-userShape.getWidth()/2,userShape.getLocY()-userShape.getHeight()/2,
                            userShape.getWidth(), userShape.getHeight());
                    break;
                case Detector.CIRCLE:
                    g.drawOval(userShape.getLocX() - userShape.getWidth()/2, userShape.getLocY() - userShape.getHeight()/2,
                            userShape.getWidth(), userShape.getHeight());
                    g.fillOval(userShape.getLocX() - userShape.getWidth()/2, userShape.getLocY() - userShape.getHeight()/2,
                            userShape.getWidth(), userShape.getHeight());
                    break;
            }

            if (index == colors.length) {
                index = 0;
            }
        }

    }

    void addUserShape(UserShape userShape) {
        userShapes.add(userShape);
    }

    ArrayList<UserShape> getUserShapes() {
        return userShapes;
    }

    void removeAllShapes() {
        userShapes.clear();
    }

    @Override
    public Dimension getPreferredSize() {
        return context.getSize();
    }
}
