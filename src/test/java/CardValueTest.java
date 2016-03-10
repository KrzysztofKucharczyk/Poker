import static org.junit.Assert.*;

import org.junit.Test;

public class CardValueTest {

	@Test
	public void shouldCreateObjectWithProperty() {

		// given
		CardValue value;
		// when
		value = new CardValue(3);

		// then
		assertNotNull(value);
		assertTrue(3 == value.getValue());

	}

	@Test
	public void shouldChangeValue() {

		// given
		CardValue value = new CardValue(4);

		// when
		value.setValue(5);

		// then
		assertTrue(5 == value.getValue());

	}

	@Test
	public void shouldReturnValue() {

		// given
		CardValue value = new CardValue(6);

		// when
		int testColor = value.getValue();

		// then
		assertTrue(6 == testColor);
	}

	@Test
	public void shouldReturnStringRepresentationOfValue() {

		// given
		CardValue value = new CardValue(7);

		// when
		String testValue = value.toString();

		// then
		assertTrue(testValue.equals("7"));
	}

	@Test
	public void shouldConvertStringToIntegerWhenNormalValue() {

		// given
		String testString = "8";

		// when
		int value = CardValue.convertValueString(testString);

		// then
		assertTrue(value == 8);
	}

	@Test
	public void shouldConvertStringToIntegerWhenSpecialValue() {

		// given
		String testString = "K";

		// when
		int value = CardValue.convertValueString(testString);

		// then
		assertTrue(value == 13);
	}

}
