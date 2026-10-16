/** Represents a single cell on the Minesweeper board. */
public class Tile {
    private final boolean isMine;
    private boolean revealed = false;
    private boolean flagged = false;

    public Tile(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isMine() { return isMine; }
    public boolean isRevealed() { return revealed; }
    public boolean isFlagged() { return flagged; }

    /** Reveals the tile if it is not flagged. */
    public void reveal() {
        if (!flagged) {
            revealed = true;
        }
    }

    /** Toggles a flag on the tile if it is not already revealed. */
    public void toggleFlag() {
        if (!revealed) {
            flagged = !flagged;
        }
    }
    /**
 * Counts the number of mines adjacent to the tile at the given coordinates
 * on the provided board. The eight neighboring cells are checked (horizontal,
 * vertical and diagonal). Out-of-bounds neighbors are ignored.
 *
 * @param board the Board instance that contains tiles (must not be null)
 * @param row the row index of this tile
 * @param col the column index of this tile
 * @return number of adjacent mines (0-8)
 * @throws IllegalArgumentException if board is null
 */
public int getAdjacentMines(Board board, int row, int col) {
    if (board == null) {
        throw new IllegalArgumentException("board cannot be null");
    }

    int count = 0;
    int rows = board.getRows();
    int cols = board.getCols();

    for (int dr = -1; dr <= 1; dr++) {
        for (int dc = -1; dc <= 1; dc++) {
            if (dr == 0 && dc == 0) continue; // skip self
            int r = row + dr;
            int c = col + dc;
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                Tile neighbor = board.getTile(r, c);
                if (neighbor != null && neighbor.isMine()) {
                    count++;
                }
            }
        }
    }

    return count;
}
// inside Tile.java
public String displayMine(Board board , int row, int col) {
    // Example using common Tile API methods; change names if necessary
    if (!isRevealed()) {
        if (isFlagged()) return "[F]";
        return "[ ]";            // hidden
    }
    if (isMine()) return "[*]"; // revealed mine
    int adj = getAdjacentMines(board , row, col);
    return "[" + (adj == 0 ? " " : adj) + "]"; // show number or blank for 0
}
}
