# Minesweeper Prototype (Project 2 – Deliverable 4)

## How to compile & run the program

```powershell
# Compile all source files
javac -cp ".;junit-4.13.jar;hamcrest-core-1.3.jar" *.java

# Run the game (starts an 8×8 board with 10 mines)
java Main
```

## Running the JUnit test suite

The tests use **JUnit 4**. Download the JARs ([junit-4.13.jar](https://repo1.maven.org/maven2/junit/junit/4.13/junit-4.13.jar) and [hamcrest-core-1.3.jar](https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)) and place them in the project root (or a `lib/` folder).

```powershell
# Compile source and test classes together
javac -cp ".;junit-4.13.jar;hamcrest-core-1.3.jar" *.java

# Execute all tests
java -cp ".;junit-4.13.jar;hamcrest-core-1.3.jar" org.junit.runner.JUnitCore LinkedChainTest CoordinateTest TileTest BoardTest MineSweeperTest TimerTest
```

> **Note:** On Windows the class‑path separator is `;`. Adjust for other OSes.

## Attribution

| File | Contributor(s) | Contribution |
|------|----------------|--------------|
| Timer.java & TimerTest.java | Matthew | Wrote the timing mechanic and tests |
| Class Framework & API Signatures | Matthew | Drafted the system design, method signatures, and normal/edge test cases |
| LinkedChain.java | Matthew | Provided generic singly‑linked collection |
| InputHandler.java | Avi | Validation (refactored for DI) |
| Main.java | Avi | Starts the prototype (`MineSweeper` launch) |
| MineSweeper.java | Avi (GenAI‑assisted) | Game orchestration, win/loss, move‑history via `LinkedChain<Coordinate>` |
| Board.java | Avi, Isabella (GenAI‑assisted) | Board creation, tile storage, mine placement, difficulty setting |
| Tile.java | Avi (GenAI‑assisted) | Tile state logic (reveal, flag) |
| MinePositions.java | Avi | Random mine coordinate generation |
| Coordinate.java | Avi | Simple immutable coordinate value object |
| All `*Test.java` files | Avi, Isabella (GenAI‑assisted) | JUnit test suite covering public methods |

**GenAI usage:** The scaffolding for new classes and most of the JUnit test‑boiler‑plate were generated with GitHub Copilot (GenAI). GenAI also assisted with the backbone for some of the more complex stretch goals. All generated code was reviewed, adapted, and approved by the team before being committed.
