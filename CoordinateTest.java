import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the methods and functionality of the Coordinate class.
 *
 */
public class CoordinateTest {

    /**
     * Tests that the constructor correctly
     * initializes the row and column.
     */
    @Test
    public void testConstructor() {
        Coordinate coord = new Coordinate(3, 5);

        assertEquals(3, coord.row);
        assertEquals(5, coord.col);
    }

    /**
     * Tests that coordinates can both be zero.
     */
    @Test
    public void testZeroCoordinates() {
        Coordinate coord = new Coordinate(0, 0);

        assertEquals(0, coord.row);
        assertEquals(0, coord.col);
    }

    /**
     * Tests that a coordinate can have a zero row.
     */
    @Test
    public void testZeroRow() {
        Coordinate coord = new Coordinate(0, 4);

        assertEquals(0, coord.row);
        assertEquals(4, coord.col);
    }

    /**
     * Tests that a coordinate can have a zero column.
     */
    @Test
    public void testZeroColumn() {
        Coordinate coord = new Coordinate(4, 0);

        assertEquals(4, coord.row);
        assertEquals(0, coord.col);
    }

    /**
     * Tests that negative row values
     * throw an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRow() {
        new Coordinate(-1, 3);
    }

    /**
     * Tests that negative column values
     * throw an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeColumn() {
        new Coordinate(3, -1);
    }

    /**
     * Tests that both coordinates cannot be negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBothNegative() {
        new Coordinate(-2, -4);
    }

    /**
     * Tests that large positive coordinates
     * are accepted.
     */
    @Test
    public void testLargeCoordinates() {
        Coordinate coord = new Coordinate(100, 200);

        assertEquals(100, coord.row);
        assertEquals(200, coord.col);
    }
}
