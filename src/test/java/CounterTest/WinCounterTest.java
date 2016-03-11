package CounterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Counter.WinCounter;

public class WinCounterTest {

	@Test
	public void shouldCreateObject() {
		// when
		WinCounter winCounter = new WinCounter();
		
		// then
		assertNotNull(winCounter);
	}

	
	@Test
	public void shouldGetAndAddPoints() {

		// given
		WinCounter winCounter = new WinCounter();
		winCounter.addPoint();
		winCounter.addPoint();
		
		// when
		int result = winCounter.getPoints();
		
		// then
		assertTrue(result == 2);
	}

	
}
