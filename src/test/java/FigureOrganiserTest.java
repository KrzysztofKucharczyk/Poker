import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FigureOrganiserTest {

	@Test
	public void should_create_object() {
		//given
		//when
		FigureOrganiser figureOrganiser = new FigureOrganiser(10, 10);
		
		//then
		assertNotNull(figureOrganiser);
	}
	
	@Test
	public void should_return_valid_frequency() {
		//given
		FigureOrganiser figureOrganiser = new FigureOrganiser(99, 10);
		
		//when
		int result = figureOrganiser.getFrequency();
		
		//then
		assertTrue(result == 99);
	}
	
	@Test
	public void should_return_valid_card_value() {
		//given
		FigureOrganiser figureOrganiser = new FigureOrganiser(99, 10);
		
		//when
		ArrayList<Integer> result = (ArrayList<Integer>) figureOrganiser.getCardValues();
		
		//then
		assertTrue(result.get(0) == 10);
	}

	@Test
	public void should_return_valid_card_values() {
		//given
		FigureOrganiser figureOrganiser = new FigureOrganiser(99, 10);
		
		//when
		ArrayList<Integer> result = (ArrayList<Integer>) figureOrganiser.getCardValues();
		result.add(new Integer(200));
		
		//then
		assertTrue(result.get(0) == 10);
		assertTrue(result.get(1) == 200);
	}
	
	@Test
	public void should_return_valid_string_representation() {
		//given
		FigureOrganiser figureOrganiser = new FigureOrganiser(99, 10);
		ArrayList<Integer> cards = (ArrayList<Integer>) figureOrganiser.getCardValues();
		cards.add(new Integer(200));
		
		//when
		String result = cards.toString();

		//then
		assertTrue(result.equals("[10, 200]"));
	}
}
