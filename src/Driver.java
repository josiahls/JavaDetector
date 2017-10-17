import java.util.Random;

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



    }
}
