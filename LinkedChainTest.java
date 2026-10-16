import org.junit.Test;
import static org.junit.Assert.*;

/** Basic tests for the generic LinkedChain implementation. */
public class LinkedChainTest {

    @Test
    public void testAddAndSize() {
        LinkedChain<String> chain = new LinkedChain<>();
        chain.add("a");
        chain.add("b");
        assertEquals(2, chain.size());
        assertTrue(chain.contains("a"));
        assertTrue(chain.contains("b"));
    }

    @Test
    public void testRemove() {
        LinkedChain<Integer> chain = new LinkedChain<>();
        chain.add(1);
        chain.add(2);
        assertTrue(chain.remove(1));
        assertEquals(1, chain.size());
        assertFalse(chain.contains(1));
        // removing missing element returns false
        assertFalse(chain.remove(99));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        LinkedChain<Integer> chain = new LinkedChain<>();
        chain.add(5);
        chain.get(1); // should throw
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrows() {
        LinkedChain<String> chain = new LinkedChain<>();
        chain.add(null); // should throw
    }

    @Test
    public void testSizeEmptyChain() {
        LinkedChain<Integer> chain = new LinkedChain<>();
        assertEquals(0, chain.size());
    }
}
