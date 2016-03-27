package HandCategory.HandCategoryMatcher;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import CardModel.ICard;
import Hand.IHand;
import HandCategory.HandCategory;
import HandCategory.HandCategoryName;

public class PokerHandCategoryMatcher implements IHandCategoryMatcher {

	private Map<Integer, Integer> matcher = new HashMap<Integer, Integer>();
	private IHand hand;

	// ---------------------------------------------------------

	public PokerHandCategoryMatcher(IHand hand) {
		this.hand = hand;
	}

	// ---------------------------------------------------------

	@Override
	public Map<Integer, Integer> getMap() {
		return matcher;
	}
	
	private Map<Integer, Integer> getFrequenciesInMatcher(IHand hand) {
		Map<Integer, Integer> matcher = new HashMap<>();

		for(ICard card: hand.getCardsList()) 
			matcher.put(card.getValue(), Collections.frequency(hand.getCardsValues(), card.getValue()));
		
		return matcher;
	}

	@Override
	public HandCategory getHandCategory() {
		matcher = getFrequenciesInMatcher(hand);

		if (isPoker()) {
			if (isRoyalPoker())
				return new HandCategory(HandCategoryName.ROYAL_FLUSH, 10);
			return new HandCategory(HandCategoryName.STRAIGHT_FLUSH, 9);
		}
		if (isFourOfAKind())
			return new HandCategory(HandCategoryName.FOUR_OF_A_KIND, 8);
		if (isFull())
			return new HandCategory(HandCategoryName.FULL, 7);
		if (isFlush())
			return new HandCategory(HandCategoryName.FLUSH, 6);
		if (isStraight())
			return new HandCategory(HandCategoryName.STRAIGHT, 5);
		if (areThreeOfAKind())
			return new HandCategory(HandCategoryName.THREE_OF_A_KIND, 4);
		if (areTwoPairs())
			return new HandCategory(HandCategoryName.TWO_PAIRS, 3);
		if (isPair())
			return new HandCategory(HandCategoryName.PAIR, 2);
		return new HandCategory(HandCategoryName.HIGH_CARD, 1);
	}

	private boolean isPair() {
		return matcher.containsValue(2);
	}

	private boolean areTwoPairs() {
		Set<Integer> cardValues = new HashSet<>();

		for (Entry<Integer, Integer> entry : matcher.entrySet())
			if (entry.getValue() == 2)
				cardValues.add(entry.getKey());

		return cardValues.size() == 2;
	}

	private boolean areThreeOfAKind() {
		return matcher.containsValue(3);
	}

	private boolean isStraight() {
		if (!specialStraightCase())
			for (int i = 1; i < hand.getCardsList().size(); i++)
				if (hand.getCardValue(i - 1) + 1 != (hand.getCardValue(i)))
					return false;

		return true;
	}

	/*
	 * Special case when straight can be created with following cards: 2X, 3X,
	 * 4X, 5X, AX (X - suite).
	 */
	private boolean specialStraightCase() {

		if (hand.getHighestValue() != 14)
			return false;
		else
			for (int i = 0; i < hand.getCardsList().size() - 1; i++)
				if (hand.getCardValue(i) != i + 2)
					return false;

		return true;
	}

	private boolean isFlush() {
		for (int i = 1; i < hand.getCardsList().size(); i++)
			if (!hand.getCardSuite(i - 1).equals(hand.getCardSuite(i)))
				return false;
		return true;
	}

	private boolean isFull() {
		return matcher.containsValue(2) && matcher.containsValue(3);
	}

	private boolean isFourOfAKind() {
		return matcher.containsValue(4);
	}

	private boolean isPoker() {
		return isStraight() && isFlush();
	}

	private boolean isRoyalPoker() {
		if (!isFlush())
			return false;

		int firstValue = 10;
		for (Integer cardValue : hand.getCardsValues())
			if (cardValue != firstValue++)
				return false;
		return true;
	}
}
