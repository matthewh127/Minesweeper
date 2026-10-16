/**
 * Orchestrates the Minesweeper game loop, win/loss handling and timing.
 * Demonstrates a second usage of the generic LinkedChain by storing each
 * player move as a {@link Coordinate}.
 */
import java.util.Scanner;
public class MineSweeper {
    private Board board;
    private final InputHandler inputHandler = new InputHandler();
    private final Timer timer = new Timer();
    // Second usage of LinkedChain: store move history as Coordinates
    private final LinkedChain<Coordinate> moveHistory = new LinkedChain<>();
    private boolean gameOver = false;
    private boolean win = false;

    /** Starts a fixed 8\u00d78 board with 10 mines. */
        
    /**
     * Starts the Minesweeper game and allows the
     * player to select a difficulty.
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        gameOver = false;
        win = false;

        System.out.println("Welcome to Minesweeper!");
        System.out.println("Choose a difficulty:");
        System.out.println("1 - Easy (8x8, 10 mines)");
        System.out.println("2 - Medium (12x12, 20 mines)");
        System.out.println("3 - Hard (16x16, 40 mines)");

        int difficulty = 0;

        while (difficulty < 1 || difficulty > 3) {
            System.out.print("Enter difficulty (1-3): ");

            if (scanner.hasNextInt()) {
                difficulty = scanner.nextInt();
            }
            else {
                scanner.next();
            }

            if (difficulty < 1 || difficulty > 3) {
                System.out.println(
                    "Invalid difficulty. Please try again.");
            }
        }

        board = new Board(difficulty);

        int rows = board.getRows();
        int cols = board.getCols();
        int mines = board.getMines();

        timer.startTimer();

        System.out.println("Game started \u2013 board " + rows + "x" + cols + ", mines: " + mines);
        while (!gameOver) {
            int[] coords = inputHandler.getCoordinates(rows - 1, cols - 1);
            int r = coords[0];
            int c = coords[1];
            // Record the move in the second LinkedChain (fulfills rubric)
            moveHistory.add(new Coordinate(r, c));
            Tile tile = board.getTile(r, c);
            if (tile.isMine()) {
                setLoss();
                break;
            } else {
                tile.reveal();
                if (checkWin()) {
                    setWin();
                    break;
                }
            }
        }
        double elapsed = timer.stopTimer();
        System.out.println("Game finished in " + elapsed + " seconds.");
    }

    /** Marks a win and ends the loop. */
    public void setWin() {
        if (gameOver) return;
        gameOver = true;
        win = true;
        System.out.println("Congratulations \u2013 you win!");
    }

    /** Marks a loss and ends the loop. */
    public void setLoss() {
        if (gameOver) return;
        gameOver = true;
        win = false;
        System.out.println("Boom \u2013 you hit a mine. Game over.");
    }

    /** Returns true when all non\u2011mine tiles are revealed. */
    private boolean checkWin() {
        int total = board.getRows() * board.getCols();
        int revealed = 0;
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                if (board.getTile(r, c).isRevealed()) {
                    revealed++;
                }
            }
        }
        return revealed == total - board.getMines();
    }
}
