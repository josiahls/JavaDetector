import java.util.Random;
import java.util.Scanner;

/**
 * @author Josiah Laivins
 *
 * @version 1.1 11/20/2017
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

                point = new UserShape(Detector.CIRCLE, pointY, pointX, 10, 10);
                detector.addShape(point);

                isTouching = detector.isPointInShapes(point);

                if (isTouching) {
                    System.out.println("Removing shape");
                    detector.removeShape(point); // Remove the point if it is already touching a shape
                    pointY = random.nextInt(500);// Re gen the points
                    pointX = random.nextInt(500);
                }
            } while (isTouching);

            System.out.println(" Moving " + pointY + "  and  " + spaceShip.getLocY());
            if (pointY < detector.getLocationY(spaceShip)) { // If the point Y is less than the shape (higher)
                for (int i = detector.getLocationY(spaceShip); i > pointY; i--) { // Reduce the ship's Y location
                    detector.moveUp(1, 1, spaceShip); // Moving the ship Up does this
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

            if (detector.isPointInShapes(point)) {
                System.out.println("Ship is at homebase");
            } else {
                System.out.println("Ship is not at homebase");
            }

            System.out.println("Would you like to try the ship nav again? y/n");
            s = scan.next().toLowerCase().charAt(0);
            if (s == 'y') {
                detector.removeShape(point);
            }

        }while (s != 'n');

        System.out.println("Goodbye!!");
    }
}
