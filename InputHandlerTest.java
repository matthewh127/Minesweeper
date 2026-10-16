import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/** Tests for {@link InputHandler} using injected Scanner instances. */
public class InputHandlerTest {

    @Test
    public void testNormalInput() {
        String input = "4\n5\n"; // row 4, column 5
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        InputHandler handler = new InputHandler(new Scanner(bais));
        int[] coords = handler.getCoordinates(8, 8);
        assertArrayEquals(new int[]{4, 5}, coords);
    }

    @Test
    public void testBadInputSurvives() {
        // Simulate various bad inputs before providing valid coordinates
        String input = "ten\n10.0\n99\n4\n5\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        InputHandler handler = new InputHandler(new Scanner(bais));
        int[] coords = handler.getCoordinates(8, 8);
        // Expect the handler to eventually read the valid values 4 and 5
        assertArrayEquals(new int[]{4, 5}, coords);
    }
}
