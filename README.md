# Minesweeper Prototype (Project 2 – Deliverable 3)

## How to compile & run the prototype

```powershell
# Compile all source files
javac *.java

# Run the game (starts an 8×8 board with 10 mines)
java Main
```

## Running the JUnit test suite

The tests use **JUnit 4**. Download the JARs (`junit-4.13.jar` and `hamcrest-core-1.3.jar`) and place them in the project root (or a `lib/` folder).

```powershell
# Compile source and test classes together
javac -cp .;junit-4.13.jar;hamcrest-core-1.3.jar *.java

# Execute all tests
java -cp .;junit-4.13.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore \
    LinkedChainTest CoordinateTest TileTest BoardTest MineSweeperTest TimerTest
```

> **Note:** On Windows the class‑path separator is `;`. Adjust for other OSes.

## Reflection

* **What changed from the specification?**
  * Added a `MineSweeper` controller class that runs the game loop (the spec listed responsibilities but did not provide an implementation).
  * Implemented `Tile`, `Board`, and `MinePositions` to provide concrete board generation and tile behavior.
  * Used the provided generic `LinkedChain<T>` for **two** element types: `Tile` (board storage) and `Coordinate` (move history).
  * Renamed the input‑handler file to `InputHandler.java` and kept all validation inside `InputHandler.getCoordinates` as required.

* **What changed in the LinkedChain?**
  * No modifications were made to the supplied `LinkedChain` implementation; we used it unchanged. The prototype simply demonstrates reuse by storing two distinct types.

* **What happened to our unknowns?**
  * We figured out how to record a history of moves using the same generic collection.
  * We learned a clean way to generate random mine positions without leaking logic into the board class.
  * Remaining unknowns: a full textual UI (board display), flagging mechanics, and difficulty selection.

* **What doesn’t work yet?**
  * The console UI is minimal – it only prompts for coordinates and prints win/loss messages.
  * No visual board display, flagging, or difficulty choice.
  * `InputHandler` tests are omitted because interactive `Scanner` input is hard to mock without redesigning the class.

## Next Steps

| Item | Owner | Status |
|------|-------|--------|
| Implement ASCII board display (show revealed tiles, flags) | Avi | Planned |
| Add flagging command (`f row col`) and integrate with `Tile.toggleFlag()` | Isabella | Planned |
| Refactor `InputHandler` to accept an injectable `Scanner` for unit testing | Matthew | Planned |
| Expand test suite to cover `InputHandler` with mocked input | Larry | Planned |
| Add difficulty settings (easy/medium/hard) and expose via command‑line argument | Avi | In‑progress |

## Attribution

| File | Contributor(s) | Contribution |
|------|----------------|--------------|
| Main.java | Avi | Starts the prototype (`MineSweeper` launch) |
| MineSweeper.java | Avi (GenAI‑assisted) | Game orchestration, win/loss, move‑history via `LinkedChain<Coordinate>` |
| Board.java | Avi (GenAI‑assisted) | Board creation, tile storage, mine placement |
| Tile.java | Avi (GenAI‑assisted) | Tile state logic (reveal, flag) |
| MinePositions.java | Avi | Random mine coordinate generation |
| Coordinate.java | Avi | Simple immutable coordinate value object |
| LinkedChain.java | Matthew (provided) | Generic singly‑linked collection implementation |
| InputHandler.java | Avi | User‑input validation (unchanged) |
| All `*Test.java` files | Avi (GenAI‑assisted) | JUnit test suite covering public methods |

**GenAI usage:** The scaffolding for new classes and most of the JUnit test boiler‑plate were generated with GitHub Copilot (GenAI). All generated code was reviewed, adapted, and approved by the team before being committed.