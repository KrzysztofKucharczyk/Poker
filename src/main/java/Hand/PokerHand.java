package Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import CardModel.Suite;
import CardModel.ICard;
import HandCategory.HandCategory;
import HandCategory.HandCategoryMatcher.IHandCategoryMatcher;
import HandCategory.HandCategoryMatcher.PokerHandCategoryMatcher;

public class PokerHand implements IHand {
	private final List<ICard> hand;
	private IHandCategoryMatcher handCategoryMatcher = new PokerHandCategoryMatcher(this);

	public PokerHand(List<ICard> cards) {
		Collections.sort(cards);
		this.hand = Collections.unmodifiableList(cards);
	}

	@Override
	public IHandCategoryMatcher getHandCategoryMatcher() {
		return handCategoryMatcher;
	}
	
	@Override
	public Map<Integer, Integer> getMap() {
		return getHandCategoryMatcher().getMap();
	}

	public List<ICard> getCardsList() {
		return hand;
	}

	public String toString() {
		String result = hand.get(0).toString();
		for (int i = 1; i < hand.size(); i++)
			result += " " + hand.get(i).toString();
		return result;
	}

	@Override
	public int getCardValue(int index) {
		return getCardsList().get(index).getValue();
	}

	@Override
	public int getHighestValue() {
		return hand.get(hand.size() - 1).getValue();
	}

	@Override
	public Suite getCardSuite(int index) {
		return hand.get(index).getSuite();
	}

	@Override
	public List<Integer> getCardsValues() {
		List<Integer> result = new ArrayList<Integer>();

		for (ICard card : hand)
			result.add(card.getValue());

		return result;
	}

	@Override
	public HandCategory getHandCategory() {
		return getHandCategoryMatcher().getHandCategory();
	}
}
