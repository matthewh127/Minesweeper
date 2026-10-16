import java.util.Scanner;

/**
 * Handles user input for row and column coordinates with validation.
 */
public class InputHandler {
    /** Scanner used for reading input – can be injected for testing. */
    private final Scanner scanner;

    /**
     * Creates an {@code InputHandler} that uses the provided {@link Scanner}.
     */
    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Creates an {@code InputHandler} that reads from {@code System.in}.
     */
    public InputHandler() {
        this(new Scanner(System.in));
    }

    /**
     * Prompts the user for row and column numbers within the provided bounds.
     * Returns an int array of size 2: [row, col].
     */
    public int[] getCoordinates(int maxRow, int maxCol) {
        int rowCoord = 0;
        int colCoord = 0;
        int tester = 0;
        while (tester == 0) {
            System.out.println("Enter your row coordinate");
            if (scanner.hasNextInt()) {
                rowCoord = scanner.nextInt();
                if (rowCoord >= 0 && rowCoord <= maxRow) {
                    tester = 67;
                } else {
                    System.out.println("Coordinate out of range. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                scanner.next();
            }
        }
        tester = 0;
        while (tester == 0) {
            System.out.println("Enter your column coordinate");
            if (scanner.hasNextInt()) {
                colCoord = scanner.nextInt();
                if (colCoord >= 0 && colCoord <= maxCol) {
                    tester = 67;
                } else {
                    System.out.println("Coordinate out of range. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                scanner.next();
            }
        }
        return new int[]{rowCoord, colCoord};
    }
    public boolean getFlagChoice() {
        System.out.println("Do you want to flag this tile? (y/n)");
        while (true) {
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }
}
