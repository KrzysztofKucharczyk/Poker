package CardTest;

import static org.junit.Assert.*;

import org.junit.Test;

import CardModel.Suite;
import CardModel.ICard;
import CardModel.PlayingCard;

public class PlayingCardTest {

	@Test
	public void shouldCreateObjectWithProperties() {

		// given
		int value = 12;
		Suite color = Suite.D;
		
		// when
		ICard testCard = new PlayingCard(value, color);
		
		// then
		assertNotNull(testCard);
		assertTrue(testCard.getValue() == 12);
		assertTrue(testCard.getSuite() == Suite.D);
	}

	@Test
	public void shouldReturnStringRepresentationOfACard() {

		// given
		int value = 14;
		Suite color = Suite.C;
		ICard testCard = new PlayingCard(value, color);
		
		// when
		String result = testCard.toString();
		
		// then
		assertTrue(result.equals("14C"));
	}
	
	@Test
	public void shouldCompareTwoCardsByValue() {

		// given
		int value = 14;
		Suite color = Suite.C;
		ICard testCard1 = new PlayingCard(value, color);
		
		value = 3;
		color = Suite.D;
		ICard testCard2 = new PlayingCard(value, color);
		
		// when
		int result = testCard1.compareTo(testCard2);
		
		// then
		assertTrue(result > 0);
	}
}
