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

    
    /**
     * Tests that easy difficulty creates
     * an 8x8 board with 10 mines.
     */
    @Test
    public void testEasyDifficulty() {
        Board board = new Board(1);

        assertEquals(8, board.getRows());
        assertEquals(8, board.getCols());
        assertEquals(10, board.getMines());
    }

    /**
     * Tests that medium difficulty creates
     * a 12x12 board with 20 mines.
     */
    @Test
    public void testMediumDifficulty() {
        Board board = new Board(2);

        assertEquals(12, board.getRows());
        assertEquals(12, board.getCols());
        assertEquals(20, board.getMines());
    }

    /**
     * Tests that hard difficulty creates
     * a 16x16 board with 40 mines.
     */
    @Test
    public void testHardDifficulty() {
        Board board = new Board(3);

        assertEquals(16, board.getRows());
        assertEquals(16, board.getCols());
        assertEquals(40, board.getMines());
    }

    /**
     * Tests that a difficulty below 1
     * throws an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDifficultyTooLow() {
        new Board(0);
    }

    /**
     * Tests that a difficulty above 3
     * throws an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDifficultyTooHigh() {
        new Board(4);
    }

}
