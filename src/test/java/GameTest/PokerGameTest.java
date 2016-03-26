package GameTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Poker.IPoker;
import Poker.PokerGame;

public class PokerGameTest {

	private IPoker pokerGame;

	@Before
	public void before() {
		String testFilePath = "src/data/test.txt";
		String[] operationSystemInformation = System.getProperty("os.name").split(" ");
		
		if(operationSystemInformation.length == 2 && operationSystemInformation[0].equals("Windows"))
			testFilePath.replace("/", "\\");
			
		pokerGame = new PokerGame(testFilePath);
	}
	
	@Test
	public void shouldSupplyHandsWithData() {
		// when
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
		pokerGame.getNewHandsForPlayers();
		pokerGame.getNewHandsForPlayers();
		pokerGame.calculatePlayersStrength();
		
		// when
		pokerGame.findWinner();
		
		// then
		assertTrue(pokerGame.getPoints() == 1);
	}

	@Test
	public void shouldCheckIfThereIsSomethingToRead() {
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
