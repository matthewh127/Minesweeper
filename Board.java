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
}
