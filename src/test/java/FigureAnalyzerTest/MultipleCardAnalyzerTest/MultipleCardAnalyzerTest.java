package FigureAnalyzerTest.MultipleCardAnalyzerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CardModel.Color;
import CardModel.ICard;
import CardModel.PlayingCard;
import Figure.FigureAnalyzer.MultipleCardAnalyzer.MultipleCardAnalyzer;
import Hand.IHand;
import Hand.PokerHand;

public class MultipleCardAnalyzerTest {

	@Test
	public void shouldReturnSortedListWithFiguresAndFrequencies_FullCase() {
		// given
		List<ICard> cards = new ArrayList<>();
		cards.add(new PlayingCard(10, Color.D));
		cards.add(new PlayingCard(2, Color.S));
		cards.add(new PlayingCard(10, Color.S));
		cards.add(new PlayingCard(2, Color.H));
		cards.add(new PlayingCard(10, Color.C));

		IHand hand = new PokerHand(cards);

		// when
		MultipleCardAnalyzer.anayzeFrequencies(hand);

		// then
		// Check if hand is sorted
		assertTrue(hand.getCardValue(0) == 2);
		assertTrue(hand.getCardValue(1) == 2);
		for (int i = 2; i < 5; i++)
			assertTrue(hand.getCardValue(i) == 10);

		// Check frequencies
		assertTrue(hand.getFigureAnalyzer().getFigureOrganisers().get(0).getCardFrequency() == 2);
		assertTrue(hand.getFigureAnalyzer().getFigureOrganisers().get(1).getCardFrequency() == 3);

		// Check repeated values
		assertTrue(hand.getHighestValue() == 10);
		assertTrue(
				hand.getCardValueFromGivenFigureOrganiser(0, 0) == 2);
	}

	@Test
	public void shouldReturnSortedListWithFiguresAndFrequencies_NoRepeatedCase() {
		// given
		List<ICard> cards = new ArrayList<>();
		cards.add(new PlayingCard(4, Color.D));
		cards.add(new PlayingCard(2, Color.S));
		cards.add(new PlayingCard(3, Color.S));
		cards.add(new PlayingCard(6, Color.H));
		cards.add(new PlayingCard(5, Color.C));

		IHand hand = new PokerHand(cards);

		// when
		MultipleCardAnalyzer.anayzeFrequencies(hand);

		// then
		// Check if hand is sorted
		for (int i = 0; i < 5; i++)
			assertTrue(hand.getCardValue(i) == i + 2);

		// Check frequencies
		assertTrue(hand.getFigureAnalyzer().getFigureOrganisers().get(0).getCardFrequency() == 1);

		// Check repeated values
		for (int i = 0; i < 5; i++)
			assertTrue(hand.getCardValueFromGivenFigureOrganiser(hand.getFigureOrganisers().size()-1, i) == i + 2);
	}

	@Test
	public void shouldReturnSortedListWithFiguresAndFrequencies_AllTheSameCase() {
		// given
		List<ICard> cards = new ArrayList<>();
		cards.add(new PlayingCard(14, Color.D));
		cards.add(new PlayingCard(14, Color.S));
		cards.add(new PlayingCard(14, Color.S));
		cards.add(new PlayingCard(14, Color.H));
		cards.add(new PlayingCard(14, Color.C));

		IHand hand = new PokerHand(cards);

		// when
		MultipleCardAnalyzer.anayzeFrequencies(hand);

		// then
		// Check frequencies
		assertTrue(hand.getFigureAnalyzer().getFigureOrganisers().get(0).getCardFrequency() == 5);

		// Check repeated values
		assertTrue(hand.getCardValueFromGivenFigureOrganiser(0, 0) == 14);
		assertTrue(hand.getFigureOrganisers().get(0).getCardValues().size() == 1);
		}
}
