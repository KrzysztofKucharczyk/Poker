package FigureTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.FigureOrganiser.PokerFigureOrganiser;

public class PokerFigureOrganiserTest {

	@Test
	public void shouldCreateObjectWithProperties() {
		// given
		IFiguresOrganiser testFigureOrganiser;
		int frequency = 100;
		int cardValue = 369;

		// when
		testFigureOrganiser = new PokerFigureOrganiser(frequency, cardValue);

		// then
		assertNotNull(testFigureOrganiser);
		assertTrue(testFigureOrganiser.getCardFrequency() == 100);
		assertTrue(testFigureOrganiser.getCardValues().get(0) == 369);
	}

	@Test
	public void shouldReturnOrganiserFrequencyNumber() {

		// given
		IFiguresOrganiser testFigureOrganiser;
		int frequency = 100;
		int cardValue = 369;
		testFigureOrganiser = new PokerFigureOrganiser(frequency, cardValue);

		// when
		int result = testFigureOrganiser.getCardFrequency();

		// then
		assertTrue(result == 100);
	}

	@Test
	public void shouldReturnOrganiserCardValue() {
		// given
		IFiguresOrganiser testFigureOrganiser;
		int frequency = 100;
		int cardValue = 369;
		testFigureOrganiser = new PokerFigureOrganiser(frequency, cardValue);

		// when
		int result = testFigureOrganiser.getCardValues().get(0);

		// then
		assertTrue(result == 369);
	}

	@Test
	public void shouldReturnStringRepresentationOfOrganiser() {
		// given
		IFiguresOrganiser testFigureOrganiser;
		int frequency = 100;
		int cardValue = 369;
		testFigureOrganiser = new PokerFigureOrganiser(frequency, cardValue);

		// when
		String result = testFigureOrganiser.toString();

		// then
		assertTrue(result.equals("[100,[369]]\n"));
	}

	@Test
	public void shouldCompareOrganiserWithAnother() {
		// given
		IFiguresOrganiser testFigureOrganiser;
		int frequency = 100;
		int cardValue = 369;
		testFigureOrganiser = new PokerFigureOrganiser(frequency, cardValue);
		
		IFiguresOrganiser anotherFigureOrganiser;
		frequency = 9;
		cardValue = 2;
		anotherFigureOrganiser = new PokerFigureOrganiser(frequency, cardValue);
		
		// when 
		int result = testFigureOrganiser.compareTo(anotherFigureOrganiser);
		
		// then
		assertTrue(result == 1);
	}

}
