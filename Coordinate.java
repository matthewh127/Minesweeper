/**
 * Simple value object representing a board coordinate (row, column).
 */
public class Coordinate {
    public final int row;
    public final int col;

    public Coordinate(int row, int col) {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative");
        }
        this.row = row;
        this.col = col;
    }
}
