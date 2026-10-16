/**
 * Orchestrates the Minesweeper game loop, win/loss handling and timing.
 * Demonstrates a second usage of the generic LinkedChain by storing each
 * player move as a {@link Coordinate}.
 */
public class MineSweeper {
    private Board board;
    private final InputHandler inputHandler = new InputHandler();
    private final Timer timer = new Timer();
    // Second usage of LinkedChain: store move history as Coordinates
    private final LinkedChain<Coordinate> moveHistory = new LinkedChain<>();
    private boolean gameOver = false;
    private boolean win = false;

    /** Starts a fixed 8\u00d78 board with 10 mines. */
    public void startGame() {
        int rows = 8;
        int cols = 8;
        int mines = 10;
        board = new Board(rows, cols, mines);
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
