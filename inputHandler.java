import java.util.Scanner;

/**
 * Handles user input for row and column coordinates with validation.
 */
public class InputHandler {
    public InputHandler() {}

    /**
     * Prompts the user for row and column numbers within the provided bounds.
     * Returns an int array of size 2: [row, col].
     */
    public int[] getCoordinates(int maxRow, int maxCol) {
        Scanner scan = new Scanner(System.in);
        int rowCoord = 0;
        int colCoord = 0;
        int tester = 0;
        while (tester == 0) {
            System.out.println("Enter your row coordinate");
            if (scan.hasNextInt()) {
                rowCoord = scan.nextInt();
                if (rowCoord >= 0 && rowCoord <= maxRow) {
                    tester = 67;
                } else {
                    System.out.println("Coordinate out of range. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                scan.next();
            }
        }
        tester = 0;
        while (tester == 0) {
            System.out.println("Enter your column coordinate");
            if (scan.hasNextInt()) {
                colCoord = scan.nextInt();
                if (colCoord >= 0 && colCoord <= maxCol) {
                    tester = 67;
                } else {
                    System.out.println("Coordinate out of range. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                scan.next();
            }
        }
        return new int[]{rowCoord, colCoord};
    }
}
