import java.util.Random;
import java.util.Scanner;

/**
 * @author Josiah Laivins
 *
 * @version 1.0 10/17/2017
 */
public class Driver {

    public static void main(String[] args) {

        Detector detector = new Detector("Hello World", 500, 500);
        Scanner scan = new Scanner(System.in);

        UserShape spaceShip = new UserShape(Detector.TRIANGLE, 250, 250, 50, 50);
        detector.addShape(spaceShip);

        Random random = new Random();
        char s = ' ';

        do {
            boolean isTouching = false;
            UserShape point;
            // Place the point, if it is in the ship regenerate
            int pointY = 250;//random.nextInt(500);
            int pointX = 250;//random.nextInt(500);
            do {

                point = new UserShape(Detector.CIRCLE,
                        pointY, pointX, 10, 10);
                detector.addShape(point);

                isTouching = detector.isPointInShapes(pointX, pointY, point);

                if (isTouching) {
                    System.out.println("Removing shape");
                    detector.removeShape(point);
                    pointY = random.nextInt(500);
                    pointX = random.nextInt(500);
                }
            } while (isTouching);

            System.out.println(" Moving " + pointY + "  and  " + spaceShip.getLocY());
            if (pointY < detector.getLocationY(spaceShip)) {
                for (int i = detector.getLocationY(spaceShip); i > pointY; i--) {
                    detector.moveUp(1, 1, spaceShip);
                }
            } else {
                for (int i = detector.getLocationY(spaceShip); i < pointY; i++) {
                    detector.moveDown(1, 1, spaceShip);
                }
            }
            System.out.println(" Moving " + pointX + "  and  " + spaceShip.getLocX());
            if (pointX < detector.getLocationX(spaceShip)) {
                for (int i = detector.getLocationX(spaceShip); i > pointX; i--) {
                    detector.moveLeft(1, 1, spaceShip);
                }
            } else {
                for (int i = detector.getLocationX(spaceShip); i < pointX; i++) {
                    detector.moveRight(1, 1, spaceShip);
                }
            }
            System.out.println("Would you like to try the ship nav again? y/n");
            s = scan.next().toLowerCase().charAt(0);
            if (s == 'y') {
                detector.removeShape(point);
            }

        }while (s != 'n');

        System.out.println("Goodbye!!");














        /*
        Random rand = new Random();

        // User can specify TRIANGLE, SQUARE, RECTANGLE, and CIRCLE
        //UserShape triangle = new UserShape(Detector.TRIANGLE, 200, 200, 100, 100);
        UserShape[] asteroids = new UserShape[10];
        for (int i = 0; i < 10; i++) {
            asteroids[i] = new UserShape(Detector.CIRCLE, 500 - (rand.nextInt(500)),
                    i * 50, 100, 100);
        }
        UserShape spaceShip = new UserShape(Detector.TRIANGLE, 200, 200, 100, 100);



        //detector.addShape(Detector.TRIANGLE, 200, 200,100, 100);
        //detector.addShape(triangle);
        for (UserShape asteroid : asteroids) {
            detector.addShape(asteroid);
        }
        detector.addShape(spaceShip);



        //detector.addShape(Detector.CIRCLE, 200, 200,100);

        //detector.addShape(circle);

        System.out.println("removing all shapes");
        /*
        for (int i = 0; i < 300; i++) {

            detector.removeAllShapes(0.1);
            detector.addShape(Detector.TRIANGLE, 200, i,
                    100, 100);
        }*/
        //detector.moveDown(100, 5, spaceShip);

        //detector.moveLeft(100, 5, spaceShip);

        //detector.moveUp(100, 5, spaceShip);

        //detector.moveRight(100, 5, spaceShip);
/*
        int[][] array = new int[100][100];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 100 * 2 + i;
            }
        }

        for (int i = 30; i < array.length; i++) {
            detector.move(250, i*8, spaceShip);
            for (int k = 0; k < asteroids.length; k++) {
                detector.moveRight(5, rand.nextInt(20)+5, asteroids[k]);
            }

        }



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
