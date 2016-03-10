import static org.junit.Assert.*;

import org.junit.Test;

public class CardColorTest {

	@Test
	public void shouldCreateObjectWithProperty() {

		// given
		CardColor color;

		// when
		color = new CardColor(Color.C);

		// then
		assertNotNull(color);
		assertTrue(Color.C == color.getColor());

	}

	@Test
	public void shouldChangeColorValue() {

		// given
		CardColor color = new CardColor(Color.C);

		// when
		color.setColor(Color.D);

		// then
		assertTrue(Color.D == color.getColor());
	}

	@Test
	public void shouldReturnColorValue() {

		// given
		CardColor color = new CardColor(Color.H);

		// when
		Color testColor = color.getColor();

		// then
		assertTrue(testColor == Color.H);
	}

	@Test
	public void shouldReturnStringRepresentationOfColorValue() {

		// given
		CardColor color = new CardColor(Color.S);

		// when
		String testColor = color.toString();

		// then
		assertTrue(testColor.equals("S"));
	}

	@Test
	public void shouldConvertStringToColor() {

		// given
		String testString = "D";

		// when
		Color color = CardColor.convertColorString(testString);

		// then
		assertTrue(color == Color.D);
	}

}
