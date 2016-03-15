import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import CardTest.CardColorTest;
import CardTest.CardValueTest;
import CardTest.PlayingCardTest;
import CounterTest.WinCounterTest;
import FigureAnalyzerTest.PokerFigureAnalyzerTest;
import FigureAnalyzerTest.MultipleCardAnalyzerTest.MultipleCardAnalyzerTest;
import FigureTest.FigureTest;
import FigureTest.PokerFigureOrganiserListTest;
import FigureTest.PokerFigureOrganiserTest;
import FileReaderTest.PokerFileReaderTest;
import GameTest.PokerGameTest;
import HandTest.PokerHandTest;

@RunWith(Suite.class)
@SuiteClasses({
	CardColorTest.class,
	CardValueTest.class,
	PlayingCardTest.class,
	WinCounterTest.class,
	PokerFigureAnalyzerTest.class,
	MultipleCardAnalyzerTest.class,
	FigureTest.class,
	PokerFigureOrganiserTest.class,
	PokerFigureOrganiserListTest.class,
	PokerFileReaderTest.class,
	PokerGameTest.class,
	PokerHandTest.class
})
public class AllTests {
	
}
