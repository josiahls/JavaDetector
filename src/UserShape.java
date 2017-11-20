import java.util.Arrays;

/**
 * @author Josiah Laivins
 *
 * @version 1.1 11/20/2017
 *
 */
public class UserShape {

    private int id;
    private static int globalID;
    private int name;
    private int locY;
    private int locX;
    private int width;
    private int height;
    private int radius;
    private int[] pointsX;
    private int[] pointsY;
    private int panelSizeY;
    private int panelSizeX;

    UserShape(int name, int panelSizeY, int panelSizeX, int locY, int locX, int width, int height,  int id) {
        this.id = id;
        this.name = name;
        this.locY = locY;
        this.locX = locX;
        this.width = width;
        this.height = height;
        this.radius = width < height ? width/2:height/2;
        this.panelSizeY = panelSizeY;
        this.panelSizeX = panelSizeX;

        setPoints();
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight() + " PanelWidthY: " + panelSizeY + " PanelHeightX: " + panelSizeX);
    }

    UserShape(int name, int locY, int locX, int width, int height) {
        id = globalID++;
        this.name = name;
        this.locY = locY;
        this.locX = locX;
        this.width = width;
        this.height = height;
        this.radius = width < height ? width/2:height/2;

        setPoints();
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight() + " PanelWidthY: " + panelSizeY + " PanelHeightX: " + panelSizeX);
    }

    @SuppressWarnings("unused")
    UserShape(int name, int locY, int locX, int radius) {
        id = globalID++;
        this.name = name;
        this.width = radius * 2;
        this.height = radius * 2;
        this.radius = radius;
        this.locY = locY;
        this.locX = locX;

        setPoints();
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight());
    }


    @SuppressWarnings("unused")
    UserShape(int name, int panelSizeY, int panelSizeX, int locY, int locX, int radius) {
        id = globalID++;
        this.name = name;
        this.width = radius * 2;
        this.height = radius * 2;
        this.radius = radius;
        this.locY = locY;
        this.locX = locX;
        this.panelSizeY = panelSizeY;
        this.panelSizeX = panelSizeX;

        setPoints();
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight());
    }

    UserShape(int name, int panelSizeY, int panelSizeX, int locY, int locX, int width, int height) {
        id = globalID++;
        this.name = name;
        this.locY = locY;
        this.locX = locX;
        this.width = width;
        this.height = height;
        this.radius = width < height ? width/2:height/2;
        this.panelSizeY = panelSizeY;
        this.panelSizeX = panelSizeX;

        setPoints();
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight() + " PanelWidthY: " + panelSizeY + " PanelHeightX: " + panelSizeX);
    }

    public void setTrianglePoints() {
        System.out.println("PanelSizeY: " + panelSizeY + " and PanelSizeX: " + panelSizeX);
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

            //System.out.println("Triangle Points: ");
            for (int i = 0; i < pointsY.length; i++) {
                //System.out.print("\tX" + i + ":" +pointsX[i] + " Y" + i + ":" + pointsY[i]);
                //System.out.println();
            }
        }
    }

    public void setPoints() {
        /*
        if (this.name == Detector.SQUARE || this.name == Detector.RECTANGLE) {
            this.pointsX = new int[4];
            this.pointsY = new int[4];
            this.pointsX[0] = this.locX - (int) width / 2;
            this.pointsX[1] = this.locX + (int) width / 2;
            this.pointsX[2] = this.locX - (int) width / 2;
            this.pointsX[3] = this.locX + (int) width / 2;
            this.pointsY[0] = this.locY + (int) height / 2;
            this.pointsY[1] = this.locY + (int) height / 2;
            this.pointsY[2] = this.locY - (int) height / 2;
            this.pointsY[3] = this.locY - (int) height / 2;
        }*/
    }

    public int getId() {
        return id;
    }

    public int getPanelSizeY() {
        return panelSizeY;
    }

    public void setPanelSizeY(int panelSizeY) {
        this.panelSizeY = panelSizeY;
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight() + " PanelWidthY: " + panelSizeY + " PanelHeightX: " + panelSizeX);
    }

    public int getPanelSizeX() {
        return panelSizeX;

    }

    public void setPanelSizeX(int panelSizeX) {
        this.panelSizeX = panelSizeX;
        setTrianglePoints();

        //System.out.println("Adding Centroid: X:" + getLocX() + " Y:" + getLocY() +
        //        " width: " + getWidth() + " height: " + getHeight() + " PanelWidthY: " + panelSizeY + " PanelHeightX: " + panelSizeX);
    }

    boolean isPointInShape(int x, int y) {
        if (getName() == Detector.CIRCLE) {
            double distanceFromCentroid = Math.sqrt(Math.pow(locX - x, 2) + Math.pow(locY - y, 2));

            //System.out.println("Centroid is: " + distanceFromCentroid + " radius is: " + radius);
            if (distanceFromCentroid < radius) {
                return true;
            }
        } else if (getName() == Detector.TRIANGLE) {
            //System.out.println("Testing the triangle");
            for (int i = 0; i <3 ; i++) {
                //System.out.println("Testing Triangle points: " + pointsX[i] + " and " + pointsY[i]);
            }
            //System.out.println("Against: x " + x + " y " + y);

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
                System.out.println("In");
                return true;
            } else {
                System.out.println("Not in");
            }
        } else if (getName() == Detector.SQUARE ||
                getName() == Detector.RECTANGLE) {

            //System.out.println("Left X: " + (locX - width / 2));
            //System.out.println("Right X: " + (locX + width / 2));
            //System.out.println("Left Y: " + (locY - width / 2));
            //System.out.println("Right Y: " + (locY + width / 2));

            if (x > locX - width / 2 && x < locX + width / 2 &&
                    y > locY - height / 2 && y < locY + height / 2) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //System.out.println("here1");
        if (o == null || getClass() != o.getClass()) return false;


        UserShape userShape = (UserShape) o;


        return this.id == userShape.getId();
    }

    public boolean isShapeInShape(UserShape userShape) {
        if (userShape.name == Detector.RECTANGLE || userShape.name == Detector.SQUARE) {

        }
        return false;
    }

    @Override
    public String toString() {
        return "UserShape{" +
                "id=" + id +
                ", name=" + name +
                ", locY=" + locY +
                ", locX=" + locX +
                ", width=" + width +
                ", height=" + height +
                ", radius=" + radius +
                ", pointsX=" + Arrays.toString(pointsX) +
                ", pointsY=" + Arrays.toString(pointsY) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name;
        result = 31 * result + locY;
        result = 31 * result + locX;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + radius;
        result = 31 * result + Arrays.hashCode(pointsX);
        result = 31 * result + Arrays.hashCode(pointsY);
        return result;
    }

    protected void setName(int name) {
        this.name = name;
    }

    int getName() {
        return name;
    }

    protected int getLocY() {
        return locY;
    }

    protected int getLocX() {
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

    protected void setLocY(int locY) {
        this.locY = locY;
    }

    protected void setLocX(int locX) {
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
