package HandTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CardModel.ICard;
import CardModel.PlayingCard;
import CardModel.Suite;
import Hand.IHand;
import Hand.PokerHand;

public class PokerHandTest {
	private IHand testHand;
	private List<ICard> testList = new ArrayList<>();
	
	@Before
	public void doBefore() {
		testList.add(new PlayingCard(10, Suite.S));
		
	}
	
	@Test
	public void shouldCreateObjectWithCard() {
		// when
		testHand = new PokerHand(testList);
		// then
		assertNotNull(testHand);
		assertTrue(testHand.getHighestValue() == 10);
		assertTrue(testHand.getCardSuite(0).equals(Suite.S));
	}

	@Test
	public void shouldReturnCardsList() {
		// given 
		testHand = new PokerHand(testList);
		
		// when
		List<ICard> result = testHand.getCardsList();
		
		// then
		assertNotNull(result);
		assertTrue(result.get(0).getValue() == 10);
		assertTrue(result.get(0).getSuite() == Suite.S);
	}
	
	@Test
	public void shouldReturnStringRepresentationOfTheHand() {		
		// given
		testList.add(new PlayingCard(2, Suite.C));
		testHand = new PokerHand(testList);
		
		// when
		String result = testHand.toString();
		
		// then
		assertTrue(result.equals("2C 10S"));
	}
	
	@Test
	public void shouldSortHand() {		
		// given
		testList.add(new PlayingCard(2, Suite.C));
		testList.add(new PlayingCard(4, Suite.H));
		testHand = new PokerHand(testList);
		
		// when
		String result = testHand.toString();
		
		// then
		assertTrue(result.equals("2C 4H 10S"));
	}
	
	@Test
	public void shouldReturnCardValue() {		
		// given
		testList.add(new PlayingCard(2, Suite.C));
		testList.add(new PlayingCard(4, Suite.H));
		testHand = new PokerHand(testList);
		
		// when
		int result = testHand.getCardValue(1);
		
		// then
		assertTrue(result == 4);
	}
	
	@Test
	public void shouldReturnLastCardValue() {		
		// given
		testList.add(new PlayingCard(2, Suite.C));
		testList.add(new PlayingCard(4, Suite.H));
		testHand = new PokerHand(testList);
		
		// when
		int result = testHand.getHighestValue();
		
		// then
		assertTrue(result == 10);
	}

	@Test
	public void shouldReturnCardColor() {		
		// given
		testList.add(new PlayingCard(2, Suite.C));
		testList.add(new PlayingCard(4, Suite.H));
		testHand = new PokerHand(testList);
		
		// when
		Suite result = testHand.getCardSuite(2);
		
		// then
		assertTrue(result.equals(Suite.S));
	}
	
	@Test
	public void shouldReturnAllCardsValues() {		
		// given
		testList.add(new PlayingCard(2, Suite.C));
		testList.add(new PlayingCard(4, Suite.H));
		testHand = new PokerHand(testList);
		
		// when
		List<Integer> result = testHand.getCardsValues();
		
		// then
		assertTrue(result.get(0) == 2);
		assertTrue(result.get(1) == 4);
		assertTrue(result.get(2) == 10);
	}
}
