import org.junit.Test;
import static org.junit.Assert.*;

/** Tests for {@link Tile}. */
public class TileTest {

    @Test
    public void testRevealNormal() {
        Tile tile = new Tile(false);
        tile.reveal();
        assertTrue(tile.isRevealed());
    }

    @Test
    public void testRevealFlaggedDoesNotChange() {
        Tile tile = new Tile(false);
        tile.toggleFlag(); // flag the tile
        tile.reveal();
        assertFalse(tile.isRevealed());
        assertTrue(tile.isFlagged());
    }
}
