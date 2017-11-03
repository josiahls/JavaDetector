import java.util.Random;
import java.util.Scanner;

/**
 * @author Josiah Laivins
 *
 * @version 1.0 10/17/2017
 */
public class Driver {

    public static void main(String[] args) {

        Detector detector =
                new Detector("Hello World", 500, 500);

        Random rand = new Random();

        // User can specify TRIANGLE, SQUARE, RECTANGLE, and CIRCLE
        detector.addShape(Detector.TRIANGLE, 200, 200,
                100, 100);

        System.out.println("removing all shapes");
        /*
        for (int i = 0; i < 300; i++) {

            detector.removeAllShapes(0.1);
            detector.addShape(Detector.TRIANGLE, 200, i,
                    100, 100);
        }*/
        detector.moveDown(100, 5);

        detector.moveLeft(100, 5);

        detector.moveUp(100, 5);

        detector.moveRight(100, 5);

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title:");
        String title = scanner.next();

        System.out.println("Enter the width and height of the window");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        Detector detector = new Detector(title, width, height);

        int shape;
        String choice = "";
        do {

            System.out.println("Enter the number for the shape you want");
            shape = scanner.nextInt();

            System.out.println("Enter the location x");
            int locx = scanner.nextInt();
            System.out.println("Enter the location y");
            int locy = scanner.nextInt();
            System.out.println("Enter the width");
            width = scanner.nextInt();
            System.out.println("Enter the height");
            height = scanner.nextInt();

            detector.addShape(shape, locx, locy, width, height);

            System.out.println("Do you want to add a point to the window?");
            choice = scanner.next();

            if (choice.toLowerCase().charAt(0) == 'y') {
                System.out.println("Enter the location x");
                int pointx = scanner.nextInt();
                System.out.println("Enter the location y");
                int pointy = scanner.nextInt();
                detector.addPoint(pointx, pointy);

                System.out.println("is the point in the shape?");
                System.out.println(detector.isPointInShapes(pointx, pointy)); // Im being lazy
                // They need to do this manually
                // Except for triangles
                // That thats hard. They can ignore it, or use isPointInShapes for that
            }


            System.out.println("Do you want to exit?");
            choice = scanner.next();

            detector.removeAllShapes();

        } while (choice.toLowerCase().charAt(0) == 'n');

        detector.removeAllShapes();

        System.out.println("Goodbye :)");




        Detector detector =
                new Detector("Hello World", 500, 500);

        Random rand = new Random();


        for (int i = 0; i < 20; i++) {
            detector.addShape(rand.nextInt(4),
                    rand.nextInt(500),
                    rand.nextInt(500),
                    rand.nextInt(500) /2,
                    rand.nextInt(500) /2);
        }

        // User can specify TRIANGLE, SQUARE, RECTANGLE, and CIRCLE
        detector.addShape(Detector.TRIANGLE, 200, 200,
                100, 100);

        if (detector.isPointInShapes(250, 200)) {
            System.out.println("Point is in shape!");
        } else {
            System.out.println("Point is in not shape!");
        }
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("removing all shapes");
        for (int i = 0; i < 300; i++) {

            detector.removeAllShapes(0.1);
            detector.addShape(Detector.TRIANGLE, 200, i,
                    100, 100);
        }


*/
    }
}
