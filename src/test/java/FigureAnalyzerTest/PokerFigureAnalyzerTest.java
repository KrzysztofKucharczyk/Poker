package FigureAnalyzerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CardModel.Color;
import CardModel.ICard;
import CardModel.PlayingCard;
import Figure.FigureAnalyzer.IFigureAnalyzer;
import Figure.FigureAnalyzer.PokerFigureAnalyzer;
import Figure.Model.Figure;
import Figure.Model.FigureName;
import Hand.IHand;
import Hand.PokerHand;

public class PokerFigureAnalyzerTest {
	private List<ICard> cards;
	private IFigureAnalyzer figureAnalyzer;

	@Before
	public void setArrayListOfCards() {
		cards = new ArrayList<>();
	}
	
	@Test
	public void shouldDetectRoyalFlush() {
		// given
		cards = new ArrayList<>();
		for (int i = 10; i < 15; i++)
			cards.add(new PlayingCard(i, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.ROYAL_FLUSH);

	}

	@Test
	public void shouldDetectStraightFlush() {
		// given
		for (int i = 3; i < 8; i++)
			cards.add(new PlayingCard(i, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.STRAIGHT_FLUSH);

	}

	@Test
	public void shouldDetectFourOfAKind() {
		// given
		cards.add(new PlayingCard(3, Color.H));
		cards.add(new PlayingCard(5, Color.S));
		cards.add(new PlayingCard(5, Color.C));
		cards.add(new PlayingCard(5, Color.D));
		cards.add(new PlayingCard(5, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.FOUR_OF_A_KIND);

	}

	@Test
	public void shouldDetectFull() {
		// given
		cards.add(new PlayingCard(3, Color.H));
		cards.add(new PlayingCard(5, Color.S));
		cards.add(new PlayingCard(3, Color.C));
		cards.add(new PlayingCard(5, Color.D));
		cards.add(new PlayingCard(5, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.FULL);

	}

	@Test
	public void shouldDetectFlush() {
		// given
		cards.add(new PlayingCard(2, Color.D));
		cards.add(new PlayingCard(4, Color.D));
		cards.add(new PlayingCard(6, Color.D));
		cards.add(new PlayingCard(8, Color.D));
		cards.add(new PlayingCard(10, Color.D));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.FLUSH);

	}
	
	@Test
	public void shouldDetectSpecialCaseStraight() {
		// given
		cards.add(new PlayingCard(14, Color.H));
		cards.add(new PlayingCard(4, Color.S));
		cards.add(new PlayingCard(5, Color.C));
		cards.add(new PlayingCard(2, Color.D));
		cards.add(new PlayingCard(3, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.STRAIGHT);

	}
	
	@Test
	public void shouldDetectStraight() {
		// given
		cards.add(new PlayingCard(7, Color.H));
		cards.add(new PlayingCard(8, Color.S));
		cards.add(new PlayingCard(10, Color.C));
		cards.add(new PlayingCard(9, Color.D));
		cards.add(new PlayingCard(11, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();
		
		// then
		assertTrue(result.getFigureName() == FigureName.STRAIGHT);

	}
	
	/*
	 * Test responsible for detecting card figure straight in 
	 * special case, which is: AX, 2X, 3X, 4X, 5X (X - color).
	 * In this case Ace can be treated as card preceding 2.
	 */
	
	@Test
	public void shouldDetectThreeOfAKind() {
		// given
		cards.add(new PlayingCard(3, Color.H));
		cards.add(new PlayingCard(2, Color.S));
		cards.add(new PlayingCard(5, Color.C));
		cards.add(new PlayingCard(5, Color.D));
		cards.add(new PlayingCard(5, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.THREE_OF_A_KIND);

	}
	
	@Test
	public void shouldDetectTwoPairs() {
		// given
		cards.add(new PlayingCard(3, Color.H));
		cards.add(new PlayingCard(3, Color.S));
		cards.add(new PlayingCard(4, Color.C));
		cards.add(new PlayingCard(5, Color.D));
		cards.add(new PlayingCard(5, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.TWO_PAIRS);

	}
	
	@Test
	public void shouldDetectPair() {
		// given
		cards.add(new PlayingCard(3, Color.H));
		cards.add(new PlayingCard(2, Color.S));
		cards.add(new PlayingCard(4, Color.C));
		cards.add(new PlayingCard(5, Color.D));
		cards.add(new PlayingCard(5, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();

		// then
		assertTrue(result.getFigureName() == FigureName.PAIR);

	}
	
	@Test
	public void shouldDetectHighCard() {
		// given
		cards.add(new PlayingCard(3, Color.H));
		cards.add(new PlayingCard(9, Color.S));
		cards.add(new PlayingCard(4, Color.C));
		cards.add(new PlayingCard(6, Color.D));
		cards.add(new PlayingCard(5, Color.H));
		IHand hand = new PokerHand(cards);
		figureAnalyzer = new PokerFigureAnalyzer(hand);

		// when
		Figure result = figureAnalyzer.getFigure();
		
		// then
		assertTrue(result.getFigureName() == FigureName.HIGH_CARD);

	}
	
}
