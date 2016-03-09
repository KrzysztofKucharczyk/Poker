import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class HandTest {

	@Test
	public void should_create_object() {
		// given
		// when
		Hand hand = new Hand();

		// then
		assertNotNull(hand);
	}

	@Test
	public void should_return_valid_size() {
		// given
		// when
		int size = Hand.size();

		// then
		assertTrue(size == 5);
	}

	@Test
	public void should_return_valid_value() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(7);
		testValues.add(2);
		testValues.add(5);
		testValues.add(9);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		int result = hand.getValue(3);

		// then
		assertTrue(result == 9);
	}
	
	@Test
	public void should_return_valid_color() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(7);
		testValues.add(2);
		testValues.add(5);
		testValues.add(9);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		String result = hand.getColor(3);

		// then
		assertTrue(result == "T");
	}
		
	@Test
	public void should_return_valid_values() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(7);
		testValues.add(2);
		testValues.add(5);
		testValues.add(9);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		ArrayList<Integer> result = (ArrayList<Integer>) hand.getValues();

		// then
		assertTrue(result.get(0) == 7);
		assertTrue(result.get(1) == 2);
		assertTrue(result.get(2) == 5);
		assertTrue(result.get(3) == 9);
		assertTrue(result.get(4) == 3);
	}
	
	@Test
	public void should_return_valid_figure_analyzer() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		ArrayList<String> testColors = new ArrayList<String>();
		Hand hand = new Hand(testValues, testColors);
		
		// when
		FigureAnalyzer testFigureAnalyzer = hand.getFigureAnalizer();

		// then
		assertNotNull(testFigureAnalyzer);
	}
	
	@Test
	public void should_return_valid_amount_of_points() {
		// given
		
		Hand hand = new Hand();

		// when
		int result = hand.getPoints();

		// then
		assertTrue(result == 0);
	}
	
	@Test
	public void should_return_valid_string_representation() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(7);
		testValues.add(2);
		testValues.add(5);
		testValues.add(9);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		String result = hand.toString();
	
		// then
		assertTrue(result.equals("7D 2D 5G 9T 3D"));
		
	}
	
	@Test
	public void should_change_hands_properties() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		ArrayList<String> testColors = new ArrayList<String>();
		Hand hand = new Hand(testValues, testColors);
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("TD");
		testList.add("5H");
		
		// when
		hand.divideStringCard(testList);
	
		// then
		assertTrue(hand.getValue(0) == 10);
		assertTrue(hand.getValue(1) == 5);

		assertTrue(hand.getColor(0).equals("D") );
		assertTrue(hand.getColor(1).equals("H"));
	}
	
	@Test
	public void should_return_appropriate_integer_card_value() {
		// given
		String[] testArray = new String[6];
		Integer[] results = new Integer[6];
		
		testArray[0] = "T";
		testArray[1] = "J";
		testArray[2] = "Q";
		testArray[3] = "K";
		testArray[4] = "A";
		testArray[5] = "5";
		
		// when
		for(int i = 0; i < 6; i++) 
			results[i] = Hand.convertCardValuesFromString(testArray[i]);
		
		// then
		assertTrue(results[0] == 10);
		assertTrue(results[1] == 11);
		assertTrue(results[2] == 12);
		assertTrue(results[3] == 13);
		assertTrue(results[4] == 14);
		assertTrue(results[5] == 5);
	}
	
	
	@Test
	public void should_return_sorted_values() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(7);
		testValues.add(2);
		testValues.add(5);
		testValues.add(9);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		hand.sort();
		String result = hand.toString();
		
		// then
		assertTrue(result.equals("2D 3D 5G 7T 9D"));
		
	}
	
	@Test
	public void should_add_points() {
		// given
		Hand hand = new Hand();

		// when
		hand.addPoint();
		hand.addPoint();
		
		// then
		assertTrue(hand.getPoints() == 2);
		
	}
		
	@Test
	public void should_return_strength_of_hand_figure() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(2);
		testValues.add(2);
		testValues.add(5);
		testValues.add(3);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		hand.sort();
		int result = hand.getStrength();
		
		// then
		assertTrue(result == 3);
		
	}

	@Test
	public void should_clear_fields() {
		// given
		ArrayList<Integer> testValues = new ArrayList<Integer>();
		testValues.add(2);
		testValues.add(2);
		testValues.add(5);
		testValues.add(3);
		testValues.add(3);
		
		ArrayList<String> testColors = new ArrayList<String>();
		testColors.add("D");
		testColors.add("D");
		testColors.add("G");
		testColors.add("T");
		testColors.add("D");
		
		Hand hand = new Hand(testValues, testColors);

		// when
		hand.clearAll();
		
		// then
		assertTrue(hand.getValues().isEmpty());
		
	}

		
	
}
