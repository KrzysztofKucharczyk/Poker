package HandCategoryMatcherTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CardModel.Suite;
import CardModel.ICard;
import CardModel.PlayingCard;
import Hand.IHand;
import Hand.PokerHand;
import HandCategory.HandCategory;
import HandCategory.HandCategoryName;
import HandCategory.HandCategoryMatcher.IHandCategoryMatcher;
import HandCategory.HandCategoryMatcher.PokerHandCategoryMatcher;

public class PokerHandCategoryMatcherTest {
	private List<ICard> cards;
	private IHandCategoryMatcher handCategoryMatcher;

	@Before
	public void setArrayListOfCards() {
		cards = new ArrayList<>();
	}
	
	@Test
	public void shouldDetectRoyalFlush() {
		// given
		cards = new ArrayList<>();
		for (int i = 10; i < 15; i++)
			cards.add(new PlayingCard(i, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.ROYAL_FLUSH);

	}

	@Test
	public void shouldDetectStraightFlush() {
		// given
		for (int i = 3; i < 8; i++)
			cards.add(new PlayingCard(i, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.STRAIGHT_FLUSH);

	}

	@Test
	public void shouldDetectFourOfAKind() {
		// given
		cards.add(new PlayingCard(3, Suite.H));
		cards.add(new PlayingCard(5, Suite.S));
		cards.add(new PlayingCard(5, Suite.C));
		cards.add(new PlayingCard(5, Suite.D));
		cards.add(new PlayingCard(5, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.FOUR_OF_A_KIND);

	}

	@Test
	public void shouldDetectFull() {
		// given
		cards.add(new PlayingCard(3, Suite.H));
		cards.add(new PlayingCard(5, Suite.S));
		cards.add(new PlayingCard(3, Suite.C));
		cards.add(new PlayingCard(5, Suite.D));
		cards.add(new PlayingCard(5, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.FULL);

	}

	@Test
	public void shouldDetectFlush() {
		// given
		cards.add(new PlayingCard(2, Suite.D));
		cards.add(new PlayingCard(4, Suite.D));
		cards.add(new PlayingCard(6, Suite.D));
		cards.add(new PlayingCard(8, Suite.D));
		cards.add(new PlayingCard(10, Suite.D));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.FLUSH);

	}
	
	/*
	 * Test responsible for detecting hand category straight in 
	 * special case, which is: AX, 2X, 3X, 4X, 5X (X - color).
	 * In this case Ace can be treated as card preceding 2.
	 */
	@Test
	public void shouldDetectSpecialCaseStraight() {
		// given
		cards.add(new PlayingCard(14, Suite.H));
		cards.add(new PlayingCard(4, Suite.S));
		cards.add(new PlayingCard(5, Suite.C));
		cards.add(new PlayingCard(2, Suite.D));
		cards.add(new PlayingCard(3, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.STRAIGHT);

	}
	
	@Test
	public void shouldDetectStraight() {
		// given
		cards.add(new PlayingCard(7, Suite.H));
		cards.add(new PlayingCard(8, Suite.S));
		cards.add(new PlayingCard(10, Suite.C));
		cards.add(new PlayingCard(9, Suite.D));
		cards.add(new PlayingCard(11, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();
		
		// then
		assertTrue(result.getName() == HandCategoryName.STRAIGHT);

	}
	
	@Test
	public void shouldDetectThreeOfAKind() {
		// given
		cards.add(new PlayingCard(3, Suite.H));
		cards.add(new PlayingCard(2, Suite.S));
		cards.add(new PlayingCard(5, Suite.C));
		cards.add(new PlayingCard(5, Suite.D));
		cards.add(new PlayingCard(5, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.THREE_OF_A_KIND);

	}
	
	@Test
	public void shouldDetectTwoPairs() {
		// given
		cards.add(new PlayingCard(3, Suite.H));
		cards.add(new PlayingCard(3, Suite.S));
		cards.add(new PlayingCard(4, Suite.C));
		cards.add(new PlayingCard(5, Suite.D));
		cards.add(new PlayingCard(5, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.TWO_PAIRS);

	}
	
	@Test
	public void shouldDetectPair() {
		// given
		cards.add(new PlayingCard(3, Suite.H));
		cards.add(new PlayingCard(2, Suite.S));
		cards.add(new PlayingCard(4, Suite.C));
		cards.add(new PlayingCard(5, Suite.D));
		cards.add(new PlayingCard(5, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();

		// then
		assertTrue(result.getName() == HandCategoryName.PAIR);

	}
	
	@Test
	public void shouldDetectHighCard() {
		// given
		cards.add(new PlayingCard(3, Suite.H));
		cards.add(new PlayingCard(9, Suite.S));
		cards.add(new PlayingCard(4, Suite.C));
		cards.add(new PlayingCard(6, Suite.D));
		cards.add(new PlayingCard(5, Suite.H));
		IHand hand = new PokerHand(cards);
		handCategoryMatcher = new PokerHandCategoryMatcher(hand);

		// when
		HandCategory result = handCategoryMatcher.getHandCategory();
		
		// then
		assertTrue(result.getName() == HandCategoryName.HIGH_CARD);

	}
	
}
