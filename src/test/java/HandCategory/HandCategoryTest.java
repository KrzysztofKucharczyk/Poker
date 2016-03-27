package HandCategory;

import static org.junit.Assert.*;

import org.junit.Test;

import HandCategory.HandCategory;
import HandCategory.HandCategoryName;

public class HandCategoryTest {

	@Test
	public void shouldCreateObjectWithPropertiesAndReturnThem() {
		// given
		HandCategory testHandCategory;
		HandCategoryName testHandCategoryName = HandCategoryName.STRAIGHT;
		int testHandCategoryValue = 10;
		
		// when
		testHandCategory = new HandCategory(testHandCategoryName, testHandCategoryValue);
		
		// then
		assertNotNull(testHandCategory);
		assertTrue(testHandCategory.getName() == HandCategoryName.STRAIGHT);
		assertTrue(testHandCategory.getValue() == 10);
	}

}
