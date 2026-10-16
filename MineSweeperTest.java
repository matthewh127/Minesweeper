import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

/** Tests for {@link MineSweeper}. */
public class MineSweeperTest {

    /** Helper to access private boolean fields via reflection. */
    private boolean getPrivateBoolean(Object obj, String fieldName) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.getBoolean(obj);
    }

    @Test
    public void testSetWinChangesState() throws Exception {
        MineSweeper game = new MineSweeper();
        // initially not over
        assertFalse(getPrivateBoolean(game, "gameOver"));
        game.setWin();
        assertTrue(getPrivateBoolean(game, "gameOver"));
    }

    @Test
    public void testSetLossIdempotent() throws Exception {
        MineSweeper game = new MineSweeper();
        game.setLoss();
        // first call should set gameOver true
        assertTrue(getPrivateBoolean(game, "gameOver"));
        // second call should not throw and leave state unchanged
        game.setLoss();
        assertTrue(getPrivateBoolean(game, "gameOver"));
    }
}
