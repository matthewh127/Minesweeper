import java.util.List;

/**
 * Represents the Minesweeper game board. Internally stores {@link Tile} instances
 * in a {@link LinkedChain} to satisfy the rubric requirement of reusing the generic
 * collection for a second element type.
 */
public class Board {
    private final int rows;
    private final int cols;
    private final int mines;
    private final LinkedChain<Tile> tiles = new LinkedChain<>();
    
    /**
     * Creates a board based on the selected difficulty.
     *
     * @param difficulty the difficulty level (1-3)
     * @throws IllegalArgumentException if difficulty is invalid
     */
    public Board(int difficulty) {
        this(getRowsForDifficulty(difficulty),
             getColsForDifficulty(difficulty),
             getMinesForDifficulty(difficulty));
    }

    /**
     * Creates a board of the given dimensions and randomly places the specified number of mines.
     */
    public Board(int rows, int cols, int mines) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Board dimensions must be positive");
        }
        if (mines < 0 || mines > rows * cols) {
            throw new IllegalArgumentException("Invalid number of mines");
        }
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;

        // Generate mine positions
        MinePositions positions = new MinePositions(rows, cols, mines);
        List<int[]> mineList = positions.getPositions();

        // Populate tiles row‑major order, marking mines appropriately
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean isMine = false;
                for (int[] p : mineList) {
                    if (p[0] == r && p[1] == c) {
                        isMine = true;
                        break;
                    }
                }
                tiles.add(new Tile(isMine));
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int getMines() { return mines; }

    /**
     * Retrieves the {@link Tile} at the specified coordinates.
     * @throws IndexOutOfBoundsException if the coordinates are outside the board.
     */
    public Tile getTile(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Coordinates out of bounds");
        }
        int index = row * cols + col; // row‑major ordering
        return tiles.get(index);
    }
    
    /**
     * Returns the number of rows based on difficulty.
     *
     * @param difficulty the selected difficulty
     * @return the number of rows
     */
    private static int getRowsForDifficulty(int difficulty) {
        switch (difficulty) {
            case 1:
                return 8;
            case 2:
                return 12;
            case 3:
                return 16;
            default:
                throw new IllegalArgumentException(
                    "Invalid difficulty");
        }
    }

    /**
     * Returns the number of columns based on difficulty.
     *
     * @param difficulty the selected difficulty
     * @return the number of columns
     */
    private static int getColsForDifficulty(int difficulty) {
        return getRowsForDifficulty(difficulty);
    }

    /**
     * Returns the number of mines based on difficulty.
     *
     * @param difficulty the selected difficulty
     * @return the number of mines
     */
    private static int getMinesForDifficulty(int difficulty) {
        switch (difficulty) {
            case 1:
                return 10;
            case 2:
                return 20;
            case 3:
                return 40;
            default:
                throw new IllegalArgumentException(
                    "Invalid difficulty");
        }
    }
    public void printBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Tile tile = getTile(r, c);
                if (tile.isRevealed()) {
                    if (tile.isMine()) {
                        System.out.print("[*]");
                    } else {
                        int adjacentMines = tile.getAdjacentMines(this, r, c);
                        System.out.print("[" + (adjacentMines > 0 ? adjacentMines : "0") + "]");
                    }
                } else if (tile.isFlagged()) {
                    System.out.print("[F]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

}
