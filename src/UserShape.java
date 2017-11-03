/**
 * @author Josiah Laivins
 *
 * @version 1.0 10/17/2017
 *
 */
public class UserShape {

    private int name;
    private int locY;
    private int locX;
    private int width;
    private int height;
    private int radius;
    private int[] pointsX;
    private int[] pointsY;

    @SuppressWarnings("unused")
    UserShape(int name, int panelSizeY, int panelSizeX, int locY, int locX, int radius) {
        this.name = name;
        this.width = radius * 2;
        this.height = radius * 2;
        this.radius = radius;
        this.locY = locY;
        this.locX = locX;

        System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
                " width: " + getWidth() + " height: " + getHeight());
    }

    UserShape(int name, int panelSizeY, int panelSizeX, int locY, int locX, int width, int height) {
        this.name = name;
        this.locY = locY;
        this.locX = locX;
        this.width = width;
        this.height = height;
        this.radius = width < height ? width/2:height/2;

        if (this.name == Detector.TRIANGLE) {
            int[] x = new int[3];
            int[] y = new int[3];

            if (this.locX - this.width / 2 < 0) {
                x[0] = 0;
            } else {
                x[0] = this.locX - this.width / 2;
            }

            if (this.locY - this.height / 2 < 0) {
                y[0] = 0;
            } else {
                y[0] = this.locY - this.height / 2;
            }

            if (this.locX + this.width / 2 > panelSizeX ) {
                x[2] = panelSizeX;
                x[1] = panelSizeX;
            } else {
                x[2] = this.locX + this.width / 2;
                x[1] = this.locX;
            }

            if (this.locY + this.height / 2 > panelSizeY ) {
                y[2] = panelSizeY;
                y[1] = panelSizeY;
            } else {
                y[2] = y[0];
                y[1] = this.locY;
            }

            pointsX = x;
            pointsY = y;

            System.out.println("Triangle Points: ");
            for (int i = 0; i < pointsY.length; i++) {
                System.out.print("\tX" + i + ":" +pointsX[i] + " Y" + i + ":" + pointsY[i]);
                System.out.println();
            }
        }

        System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
                " width: " + getWidth() + " height: " + getHeight() + " PanelWidthY: " + panelSizeY + " PanelHeightX: " + panelSizeX);
    }

    boolean isPointInShape(int x, int y) {
        if (getName() == Detector.CIRCLE) {
            double distanceFromCentroid = Math.sqrt(Math.pow(locX - x, 2) + Math.pow(locY - y, 2));

            System.out.println("Centroid is: " + distanceFromCentroid + " radius is: " + radius);
            if (distanceFromCentroid < radius) {
                return true;
            }
        } else if (getName() == Detector.TRIANGLE) {

            // Calculate whether a point is in a triangle using the
            // Barycentric coordinate system
            // First find T, which is a matrix of linearly
            // independent vertexes
            double[][] T = new double[2][2];
            T[0][0] = pointsX[0] - pointsX[2];
            T[0][1] = pointsX[1] - pointsX[2];
            T[1][0] = pointsY[0] - pointsY[2];
            T[1][1] = pointsY[1] - pointsY[2];

            // Find the determinant
            double detT = T[0][0] * T[1][1] - T[1][0] * T[0][1];

            // Find the 3 alphas
            double alpha1 = ((pointsY[1] - pointsY[2]) * (x - pointsX[2])) +
                    (pointsX[2]-pointsX[1]) * (y - pointsY[2]);
            alpha1 /= detT;

            double alpha2 = ((pointsY[2] - pointsY[0]) * (x - pointsX[2])) +
                    (pointsX[0] - pointsX[2]) * (y - pointsY[2]);
            alpha2 /= detT;

            double alpha3 = 1 - alpha1 - alpha2;

            // If any of the alphas is less than zero then the point is not in the triangle
            if (alpha1 >= 0 && alpha2 >= 0 && alpha3 >= 0) {
                return true;
            }
        } else if (getName() == Detector.SQUARE ||
                getName() == Detector.RECTANGLE) {

            System.out.println("Left X: " + (locX - width / 2));
            System.out.println("Right X: " + (locX + width / 2));
            System.out.println("Left Y: " + (locY - width / 2));
            System.out.println("Right Y: " + (locY + width / 2));

            if (x > locX - width / 2 && x < locX + width / 2 &&
                    y > locY - height / 2 && y < locY + height / 2) {
                return true;
            }
        }

        return false;
    }

    protected void setName(int name) {
        this.name = name;
    }

    int getName() {
        return name;
    }

    int getLocY() {
        return locY;
    }

    int getLocX() {
        return locX;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    int[] getPointsX() {
        return pointsX;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    protected void setPointsX(int[] pointsX) {
        this.pointsX = pointsX;
    }

    int[] getPointsY() {
        return pointsY;
    }

    protected void setPointsY(int[] pointsY) {
        this.pointsY = pointsY;
    }

    protected int getRadius() {
        return radius;
    }

    protected void setRadius(int radius) {
        this.radius = radius;
    }
}
