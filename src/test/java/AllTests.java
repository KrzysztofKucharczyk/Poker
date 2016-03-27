import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import CardTest.PlayingCardTest;
import CounterTest.WinCounterTest;
import FileReaderTest.PokerFileReaderTest;
import GameTest.PokerGameTest;
import HandCategory.HandCategoryTest;
import HandCategoryMatcherTest.PokerHandCategoryMatcherTest;
import HandTest.PokerHandTest;

@RunWith(Suite.class)
@SuiteClasses({
	PlayingCardTest.class,
	WinCounterTest.class,
	PokerHandCategoryMatcherTest.class,
	HandCategoryTest.class,
	PokerFileReaderTest.class,
	PokerGameTest.class,
	PokerHandTest.class
})

public class AllTests {
	
}
