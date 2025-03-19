
package trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {
	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	void testAddPlayer() {
		// Ajouter un joueur
		assertTrue(game.add("Alice"));
		assertTrue(game.add("Bob"));
	}

	@Test
	void testHandleCorrectAnswer() {
		game.add("Alice");

		game.roll(3);
		assertTrue(game.handleCorrectAnswer());
		assertEquals(1, game.getPlayers().get(0).getCoins());
	}

	@Test
	void testHandleWrongAnswer() {
		game.add("Alice");

		game.roll(2);
		assertTrue(game.handleWrongAnswer());
		assertTrue(game.getPlayers().get(0).isInPenaltyBox());
	}

	@Test
	void testGameOverCondition() {
		game.add("Alice");

		game.roll(1);
		game.handleCorrectAnswer();
		game.roll(1);
		game.handleCorrectAnswer();
		game.roll(1);
		game.handleCorrectAnswer();
		game.roll(1);
		game.handleCorrectAnswer();
		game.roll(1);
		game.handleCorrectAnswer();
		game.roll(1);
		assertFalse(game.handleCorrectAnswer());
	}

	@Test
	void testNextPlayer() {
		game.add("Alice");
		game.add("Bob");

		game.roll(1);
		game.handleCorrectAnswer();
		assertEquals("Bob", game.getCurrentPlayer().getName());
	}

	@Test
	void testInPenaltyBox() {
		game.add("Alice");
		game.add("Bob");

		game.roll(1);
		Player currentPlayer = game.getCurrentPlayer();
		game.handleWrongAnswer();
		assertTrue(currentPlayer.isInPenaltyBox());
	}

	@Test
	void testIsGettingOutOfPenaltyBox() {
		game.add("Alice");
		game.add("Bob");

		game.roll(1);
		Player currentPlayer = game.getCurrentPlayer();
		game.handleWrongAnswer();
		assertTrue(currentPlayer.isInPenaltyBox());

		game.roll(1);
		Player currentPlayer2 = game.getCurrentPlayer();
		game.handleCorrectAnswer();
		assertFalse(currentPlayer2.isInPenaltyBox());

		game.roll(1);
		game.handleCorrectAnswer();
		assertFalse(currentPlayer.isInPenaltyBox());
	}

	@Test
	@Disabled("enable back to see the output of the game")
	void caracterizationTest() {
		// runs 10.000 "random" games to see the output of old and new code mathces
		for (int seed = 1; seed < 10_000; seed++) {
			testSeed(seed, false);
		}
	}

	private void testSeed(int seed, boolean printExpected) {
		String expectedOutput = extractOutput(new Random(seed), new GameOld());
		if (printExpected) {
			System.out.println(expectedOutput);
		}
		String actualOutput = extractOutput(new Random(seed), new Game());
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	@Disabled("enable back and set a particular seed to see the output")
	void oneSeed() {
		testSeed(1, true);
	}

	private String extractOutput(Random rand, IGame aGame) {
		PrintStream old = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (PrintStream inmemory = new PrintStream(baos)) {
			// WARNING: System.out.println() doesn't work in this try {} as the sysout is captured and recorded in memory.
			System.setOut(inmemory);

			aGame.add("Chet");
			aGame.add("Pat");
			aGame.add("Sue");

			boolean notAWinner = false;
			do {
				aGame.roll(rand.nextInt(5) + 1);

				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.handleWrongAnswer();
				} else {
					notAWinner = aGame.handleCorrectAnswer();
				}

			} while (notAWinner);
		} finally {
			System.setOut(old);
		}

		return new String(baos.toByteArray());
	}
}
