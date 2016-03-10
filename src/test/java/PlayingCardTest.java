import static org.junit.Assert.*;

import org.junit.Test;

public class PlayingCardTest {

	@Test
	public void shouldCreateObjectWithProperties() {

		// given
		int value = 12;
		Color color = Color.D;
		
		// when
		ICard testCard = new PlayingCard(value, color);
		
		// then
		assertNotNull(testCard);
		assertTrue(testCard.getValue() == 12);
		assertTrue(testCard.getColor() == Color.D);
	}
	
	@Test
	public void shouldReturnCardValue() {

		// given
		int value = 5;
		Color color = Color.D;
		ICard testCard = new PlayingCard(value, color);
		
		// when
		int result = testCard.getValue();
		
		// then
		assertTrue(result == 5);
	}
	
	@Test
	public void shouldReturnCardColor() {

		// given
		int value = 7;
		Color color = Color.H;
		ICard testCard = new PlayingCard(value, color);
		
		// when
		Color result = testCard.getColor();
		
		// then
		assertTrue(result == Color.H);
	}
	
	@Test
	public void shouldReturnStringRepresentationOfACard() {

		// given
		int value = 14;
		Color color = Color.C;
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
		Color color = Color.C;
		ICard testCard1 = new PlayingCard(value, color);
		
		value = 3;
		color = Color.D;
		ICard testCard2 = new PlayingCard(value, color);
		
		// when
		int result = testCard1.compareTo(testCard2);
		
		// then
		assertTrue(result == 1);
	}
	
		

}
