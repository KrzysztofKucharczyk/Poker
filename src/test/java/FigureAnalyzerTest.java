//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//
//import org.junit.Test;
//
//public class FigureAnalyzerTest {
//
//	/* 
//	 * Test focused on detecting appropriate figure.
//	 */
//	
//	@Test
//	public void should_create_object() {
//		// given
//		Handa hand = new Handa();
//		
//		// when
//		FigureAnalyzer figureAnalyzer = new FigureAnalyzer(hand);
//
//		// then
//		assertNotNull(figureAnalyzer);
//	}
//	
//	@Test
//	public void should_detect_high_card() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(7);
//		testValues.add(2);
//		testValues.add(5);
//		testValues.add(9);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("G");
//		testColors.add("T");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 1);
//	}
//	
//	@Test
//	public void should_detect_pair() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(7);
//		testValues.add(3);
//		testValues.add(5);
//		testValues.add(6);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("G");
//		testColors.add("T");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 2);
//	}
//	
//	@Test
//	public void should_detect_two_pairs() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(2);
//		testValues.add(5);
//		testValues.add(3);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("G");
//		testColors.add("T");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 3);
//	}
//	
//	@Test
//	public void should_detect_three_of_a_kind() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(3);
//		testValues.add(4);
//		testValues.add(3);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("G");
//		testColors.add("T");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 4);
//	}
//	
//	@Test
//	public void should_detect_straight() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(3);
//		testValues.add(4);
//		testValues.add(5);
//		testValues.add(6);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("G");
//		testColors.add("T");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 5);
//	}
//	
//	@Test
//	public void should_detect_flush() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(4);
//		testValues.add(1);
//		testValues.add(2);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 6);
//	}
//	
//	@Test
//	public void should_detect_full() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(2);
//		testValues.add(2);
//		testValues.add(3);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 7);
//	}
//	
//	@Test
//	public void should_detect_four_of_a_kind() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(2);
//		testValues.add(2);
//		testValues.add(2);
//		testValues.add(3);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 8);
//	}
//	
//	@Test
//	public void should_detect_poker() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(2);
//		testValues.add(3);
//		testValues.add(4);
//		testValues.add(5);
//		testValues.add(6);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 9);
//	}
//	
//	@Test
//	public void should_detect_royal_poker() {
//		// given
//		ArrayList<Integer> testValues = new ArrayList<Integer>();
//		testValues.add(10);
//		testValues.add(11);
//		testValues.add(12);
//		testValues.add(13);
//		testValues.add(14);
//		
//		ArrayList<String> testColors = new ArrayList<String>();
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//		testColors.add("D");
//
//		Handa hand = new Handa(testValues, testColors);
//	
//		// when
//		int result = hand.getStrength();
//		
//		// then
//		assertTrue(result == 10);
//	}
//		
//}
