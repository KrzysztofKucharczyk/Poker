package GameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Poker.IPoker;
import Poker.PokerGame;

public class PokerGameTest {

	private IPoker pokerGame;

	@Test
	public void shouldSupplyHandsWithData() {
		// when
		pokerGame = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		pokerGame.getNewHandsForPlayers();

		// then
		for (int i = 0; i < 5; i++)
			assertTrue(pokerGame.getPlayer().getCardsValues().get(i) == i + 1);
		
		for (int i = 0; i < 5; i++)
			assertTrue(pokerGame.getEnemy().getCardsValues().get(i) == i + 6);
	}
	
	@Test
	public void shouldCalculateTheStrengthOfEveryHand() {
		// given
		pokerGame = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		pokerGame.getNewHandsForPlayers();

		// when
		pokerGame.calculatePlayersStrength();
		
		// then
		assertTrue(pokerGame.getPlayerStrength() == 9);
		assertTrue(pokerGame.getEnemyStrength() == 9);
	}
	
	@Test
	public void shouldDecideWhoIsTheWinner() {
		// given
		pokerGame = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		pokerGame.getNewHandsForPlayers();
		pokerGame.getNewHandsForPlayers();
		pokerGame.calculatePlayersStrength();
		
		// when
		pokerGame.findWinner();
		
		// then
		assertTrue(pokerGame.getPoints() == 1);
	}

	@Test
	public void shouldClearhands() {
		// given
		pokerGame = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		pokerGame.getNewHandsForPlayers();
		
		// when
		pokerGame.cleanAfterMatch();
		
		// then
		assertTrue(pokerGame.getPlayer().getCardsList().isEmpty());
		assertTrue(pokerGame.getEnemy().getCardsList().isEmpty());
	}
	
	@Test
	public void shouldCheckIfThereIsSomethingToRead() {
		// given
		pokerGame = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		
		// when
		pokerGame.getNewHandsForPlayers();
		
		// then
		assertTrue(pokerGame.isInput());
		
		// when
		pokerGame.getNewHandsForPlayers();
		
		// then
		assertFalse(pokerGame.isInput());
	}
	
}
