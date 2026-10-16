import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Generates random mine positions for a board. */
public class MinePositions {
    private final List<int[]> positions = new ArrayList<>();

    public MinePositions(int rows, int cols, int numMines) {
        if (numMines < 0 || numMines > rows * cols) {
            throw new IllegalArgumentException("Invalid number of mines");
        }
        Random rand = new Random();
        while (positions.size() < numMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            boolean exists = positions.stream().anyMatch(p -> p[0] == r && p[1] == c);
            if (!exists) {
                positions.add(new int[]{r, c});
            }
        }
    }

    public List<int[]> getPositions() {
        return positions;
    }
}
