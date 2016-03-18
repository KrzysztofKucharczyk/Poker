package HandTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CardModel.Color;
import CardModel.ICard;
import CardModel.PlayingCard;
import Figure.FigureAnalyzer.IFigureAnalyzer;
import Figure.FigureAnalyzer.PokerFigureAnalyzer;
import Hand.IHand;
import Hand.PokerHand;

public class PokerHandTest {
	private IHand testHand;
	private List<ICard> testList = new ArrayList<>();
	
	@Before
	public void doBefore() {
		testList.add(new PlayingCard(10, Color.S));
		
	}
	
	@Test
	public void shouldCreateObjectWithCard() {
		// when
		testHand = new PokerHand(testList);
		// then
		assertNotNull(testHand);
		assertTrue(testHand.getHighestValue() == 10);
		assertTrue(testHand.getCardColor(0).equals(Color.S));
	}
	
	@Test
	public void shouldReturnFigureAnalyzer() {				
		// given
		testHand = new PokerHand(testList);
		
		// when
		IFigureAnalyzer testFihureAnalyzer = testHand.getFigureAnalyzer();
		
		// then
		assertNotNull(testFihureAnalyzer);
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
		assertTrue(result.get(0).getColor() == Color.S);
	}
	
	@Test
	public void shouldReturnStringRepresentationOfTheHand() {		
		// given
		testList.add(new PlayingCard(2, Color.C));
		testHand = new PokerHand(testList);
		
		// when
		String result = testHand.toString();
		
		// then
		assertTrue(result.equals("2C 10S"));
	}
	
	@Test
	public void shouldSortHand() {		
		// given
		testList.add(new PlayingCard(2, Color.C));
		testList.add(new PlayingCard(4, Color.H));
		testHand = new PokerHand(testList);
		
		// when
		String result = testHand.toString();
		
		// then
		assertTrue(result.equals("2C 4H 10S"));
	}
	
	@Test
	public void shouldReturnCardValue() {		
		// given
		testList.add(new PlayingCard(2, Color.C));
		testList.add(new PlayingCard(4, Color.H));
		testHand = new PokerHand(testList);
		
		// when
		int result = testHand.getCardValue(1);
		
		// then
		assertTrue(result == 4);
	}
	
	@Test
	public void shouldReturnLastCardValue() {		
		// given
		testList.add(new PlayingCard(2, Color.C));
		testList.add(new PlayingCard(4, Color.H));
		testHand = new PokerHand(testList);
		
		// when
		int result = testHand.getHighestValue();
		
		// then
		assertTrue(result == 10);
	}

	@Test
	public void shouldReturnCardColor() {		
		// given
		testList.add(new PlayingCard(2, Color.C));
		testList.add(new PlayingCard(4, Color.H));
		testHand = new PokerHand(testList);
		
		// when
		Color result = testHand.getCardColor(2);
		
		// then
		assertTrue(result.equals(Color.S));
	}
	
	@Test
	public void shouldReturnAllCardsValues() {		
		// given
		testList.add(new PlayingCard(2, Color.C));
		testList.add(new PlayingCard(4, Color.H));
		testHand = new PokerHand(testList);
		
		// when
		List<Integer> result = testHand.getCardsValues();
		
		// then
		assertTrue(result.get(0) == 2);
		assertTrue(result.get(1) == 4);
		assertTrue(result.get(2) == 10);
	}
	
	@Test
	public void shouldSetFigureAnalyzer() {		
		// given
		testHand = new PokerHand(testList);
		IHand testHand2 = new PokerHand(testList);
		IFigureAnalyzer newFigureAnalyzer = new PokerFigureAnalyzer(testHand2);
	    IFigureAnalyzer oldFigureAnalyzer = testHand.getFigureAnalyzer();
		
		// when
		testHand.setFigureAnalyzer(newFigureAnalyzer);
		
		// then
		assertFalse(testHand.getFigureAnalyzer().equals(oldFigureAnalyzer));
		}
}
