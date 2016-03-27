package DrawResolver;

import java.util.Map.Entry;

import Hand.IHand;
import HandCategory.HandCategoryName;

public class DrawResolver {

	public static int resolve(IHand player, IHand enemy) {
		HandCategoryName handCategoryName = player.getHandCategory().getName();

		// straight flushes and royal flushes always results in draw
		if (handCategoryName == HandCategoryName.ROYAL_FLUSH)
			return 0;
		if (handCategoryName == HandCategoryName.STRAIGHT_FLUSH)
			return 0;
		if (handCategoryName == HandCategoryName.FOUR_OF_A_KIND || handCategoryName == HandCategoryName.THREE_OF_A_KIND
				|| handCategoryName == HandCategoryName.FULL)
			return iterateThroughRestValues(player, enemy, 1);
		if (handCategoryName == HandCategoryName.TWO_PAIRS)
			return iterateThroughRestValues(player, enemy, 2);
		if (handCategoryName == HandCategoryName.PAIR)
			return resolvePairConflict(player, enemy);
		// includes FLUSH and HIGH_CARD
		return iterateThroughRestValues(player, enemy, 0);
	}

	private static int resolvePairConflict(IHand player, IHand enemy) {
		return (getCardValueWithGivenFrequency(player, 2) > getCardValueWithGivenFrequency(enemy, 2)) ? 1 : 2;
	}
	
	private static int getCardValueWithGivenFrequency(IHand hand, int frequency) {
		int result = 0;
		
		for(Entry<Integer, Integer> entry : hand.getMap().entrySet())
			if(entry.getValue() == frequency)
				result = entry.getKey();
		
		return result;
	}

	private static int iterateThroughRestValues(IHand hand1, IHand hand2, int bound) {
		for (int i = hand1.getCardsList().size() - 1; i > 0; i--) {
			if (hand1.getCardValue(i) > hand2.getCardValue(i))
				return 1;
			else if (hand1.getCardValue(i) < hand2.getCardValue(i))
				return 2;
		}
		return 2;
	}
}
