import org.junit.Test;
import static org.junit.Assert.*;

/** Tests for {@link Board}. */
public class BoardTest {

    @Test
    public void testBoardGeneration() {
        int rows = 5;
        int cols = 4;
        int mines = 3;
        Board board = new Board(rows, cols, mines);
        assertEquals(rows, board.getRows());
        assertEquals(cols, board.getCols());
        assertEquals(mines, board.getMines());
        // Verify all tiles are created and accessible
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Tile t = board.getTile(r, c);
                assertNotNull(t);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetTileOutOfBounds() {
        Board board = new Board(3, 3, 1);
        board.getTile(-1, 0); // should throw
    }
}
