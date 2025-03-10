package trivia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerName() {
        Player player = new Player("John");
        assertEquals("John", player.getName());
    }

    @Test
    void testInitialPosition() {
        Player player = new Player("John");
        assertEquals(1, player.getPosition());
    }

    @Test
    void testInitialCoins() {
        Player player = new Player("John");
        assertEquals(0, player.getCoins());
    }

    @Test
    void testInitialPenaltyBoxStatus() {
        Player player = new Player("John");
        assertFalse(player.isInPenaltyBox());
    }

    @Test
    void testMove() {
        Player player = new Player("John");
        player.move(3, 12);
        assertEquals(4, player.getPosition()); // 1 + 3 = 4
    }

    @Test
    void testMoveWrapAround() {
        Player player = new Player("John");
        player.move(12, 12); // This should wrap around to position 12
        assertEquals(1, player.getPosition());

        player.move(1, 12); // This should wrap around to position 1
        assertEquals(2, player.getPosition());

        player.move(3, 12); // This should wrap around to position 1
        assertEquals(5, player.getPosition());
    }


    @Test
    void testAddCoin() {
        Player player = new Player("John");
        player.addCoin();
        assertEquals(1, player.getCoins());
    }

    @Test
    void testSendToPenaltyBox() {
        Player player = new Player("John");
        player.sendToPenaltyBox();
        assertTrue(player.isInPenaltyBox());
    }

    @Test
    void testGetOutOfPenaltyBox() {
        Player player = new Player("John");
        player.sendToPenaltyBox();
        player.getOutOfPenaltyBox();
        assertFalse(player.isInPenaltyBox());
    }
}
