public class InputHandlerTest {

    @Test
    public void testGetCoordinates() {
        InputHandler input = new InputHandler();
        int[] coordinates = input.getCoordinates(5, 5);

        assertTrue(coordinates[0] >= 0 && coordinates[0] <= 5);
        assertTrue(coordinates[1] >= 0 && coordinates[1] <= 5);
    }
}