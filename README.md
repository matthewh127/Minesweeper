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

* **What changed from the spec?**
  * Added a `MineSweeper` controller class that runs the game loop.
  * Implemented `Tile`, `Board`, and `MinePositions` to provide concrete board generation and tile behavior.
  * Used the generic `LinkedChain<T>` for two element types: `Tile` (board storage) and `Coordinate` (move history).
  * Refactored `InputHandler` to use dependency‑injected `Scanner` (validation now lives in `InputHandler`).

* **What changed in the LinkedChain?**
  * The `LinkedChain` implementation was left unchanged; it is used unchanged as supplied.

* **What happened to unknowns?**
  * Figured out how to record move history using the generic collection.
  * Determined a clean way to generate random mine positions without leaking logic into the board class.
  * Remaining unknowns: full textual UI, flagging mechanics, and difficulty selection.

* **What doesn’t work yet?**
  * Minimal console UI – only prompts for coordinates and prints win/loss messages.
  * No visual board display, flagging, or difficulty selection.
  * `InputHandler` tests were previously missing; now added with DI.

## Next Steps

* **What is left to finish the MVP?**
  1. Implement ASCII board display showing revealed tiles and flags.
  2. Add flagging command (`f row col`) and integrate with `Tile.toggleFlag()`.
  3. Provide difficulty selection (easy/medium/hard) via command‑line argument.
  4. Complete UI polish and input prompts.
* **Which stretch goals are committed vs. dropped?**
  * Committed: move‑history tracking, timing mechanic, basic test suite.
  * Dropped: networked multiplayer, AI opponent, persistent high‑score storage.
* **What new tests are needed?**
  * Additional edge‑case tests for `InputHandler` (already added).
  * Tests for board display formatting and flag toggling.
* **Who does what?**
  * Avi – UI display and difficulty settings.
  * Isabella – Flagging feature implementation.
  * Matthew – Final review of `LinkedChain` usage and test coverage.
  * Larry – Write additional JUnit tests for board and tile logic.

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

**GenAI usage:** The scaffolding for new classes and most of the JUnit test‑boiler‑plate were generated with GitHub Copilot (GenAI). All generated code was reviewed, adapted, and approved by the team before being committed.
