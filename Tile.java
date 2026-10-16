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
}
