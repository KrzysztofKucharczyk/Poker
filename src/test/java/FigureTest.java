import static org.junit.Assert.*;

import org.junit.Test;

public class FigureTest {

	@Test
	public void shouldCreateObjectWithPropertiesAndReturnThem() {
		// given
		Figure testFigure;
		FigureName testFigureName = FigureName.STRAIGHT;
		int testFigureValue = 10;
		
		// when
		testFigure = new Figure(testFigureName, testFigureValue);
		
		// then
		assertNotNull(testFigure);
		assertTrue(testFigure.getFigureName() == FigureName.STRAIGHT);
		assertTrue(testFigure.getFigureValue() == 10);
	}

}
