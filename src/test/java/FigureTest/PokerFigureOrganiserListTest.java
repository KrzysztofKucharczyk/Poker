package FigureTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.FigureOrganiser.PokerFigureOrganiser;
import Figure.FiguresOrganiserList.IFiguresOrganiserList;
import Figure.FiguresOrganiserList.PokerFigureOrganiserList;

public class PokerFigureOrganiserListTest {

	private IFiguresOrganiserList testFigureOrganiser;
	
	@Test
	public void shouldCreateObject() {
		// when
		testFigureOrganiser = new PokerFigureOrganiserList();
	
		// then
		assertNotNull(testFigureOrganiser);
	}
	
	@Test
	public void shouldAddItemToList() {
		//given
		testFigureOrganiser = new PokerFigureOrganiserList();
		
		// when
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(2, 2));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 4));
	
		// then
		assertTrue(testFigureOrganiser.size() == 2);
	}
	
	@Test
	public void shouldReturnLastElementFrequency() {
		//given
		testFigureOrganiser = new PokerFigureOrganiserList();
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(2, 2));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 4));
		
		// when
		int testFrequency = testFigureOrganiser.getFrequencyOfLastElement();
	
		// then
		assertTrue(testFrequency == 3);
	}
	
	@Test
	public void shouldReturnLastElementValue() {
		//given
		testFigureOrganiser = new PokerFigureOrganiserList();
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(2, 2));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 4));
		
		// when
		List<Integer> testList = testFigureOrganiser.getCardValuesOfLastElement();
	
		// then
		assertTrue(testList.get(0) == 4);
	}
	
	@Test
	public void shouldReturnListOfFigures() {
		//given
		testFigureOrganiser = new PokerFigureOrganiserList();
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(2, 2));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 4));
		
		// when
		List<IFiguresOrganiser> testFrequency = testFigureOrganiser.getFiguresList();
	
		// then
		assertTrue(testFrequency.size() == 2);
		assertTrue(testFrequency.get(0).getCardValues().get(0) == 2 && testFrequency.get(1).getCardValues().get(0) == 4);
	}
	
	@Test
	public void shouldReturnFigureFrequency() {
		//given
		testFigureOrganiser = new PokerFigureOrganiserList();
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(2, 2));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 4));
		
		// when
		int testFrequency = testFigureOrganiser.getCardFrequency(1);
	
		// then
		assertTrue(testFrequency == 3);
	}
	
	@Test
	public void shouldReturnSize() {
		//given
		testFigureOrganiser = new PokerFigureOrganiserList();
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(2, 2));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 4));
		testFigureOrganiser.addFigure(new PokerFigureOrganiser(3, 14));
		
		// when
		int result = testFigureOrganiser.size();
		
		// then
		assertTrue(result == 3);
	}
	
}
