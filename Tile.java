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
}
