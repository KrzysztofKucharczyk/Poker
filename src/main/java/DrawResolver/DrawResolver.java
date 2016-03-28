package DrawResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Hand.IHand;
import HandCategory.HandCategoryName;
import Poker.GameResult;

public class DrawResolver {

	public static GameResult resolve(IHand player, IHand enemy) {

		HandCategoryName handCategoryName = player.getHandCategory().getName();
		enemy.getHandCategory();

		// royal flushes always results in draw
		if (handCategoryName == HandCategoryName.ROYAL_FLUSH)
			return GameResult.DRAW;
		// depends on highest card
		if (handCategoryName == HandCategoryName.STRAIGHT_FLUSH
				|| handCategoryName == HandCategoryName.FLUSH
				|| handCategoryName == HandCategoryName.STRAIGHT)
			compareHighestCards(player, enemy);
		if (handCategoryName == HandCategoryName.FOUR_OF_A_KIND)
			return resolveFourOfAKindDraw(player, enemy);
		if (handCategoryName == HandCategoryName.THREE_OF_A_KIND)
			return resolveThreeOfAKindDraw(player, enemy);
		if (handCategoryName == HandCategoryName.FULL)
			return resolveFullDraw(player, enemy);
		if (handCategoryName == HandCategoryName.TWO_PAIRS)
			return resolveTwoPairDraw(player, enemy);
		if (handCategoryName == HandCategoryName.PAIR)
			return resolvePairDraw(player, enemy);
		return iterateThroughRestValues(player, enemy, 0);
	}

	private static GameResult iterateThroughRestValues(IHand hand1,
			IHand hand2, int bound) {
		for (int i = hand1.getCardsList().size() - 1; i > 0; i--) {
			if (hand1.getCardValue(i) > hand2.getCardValue(i))
				return GameResult.PLAYER_WON;
			else if (hand1.getCardValue(i) < hand2.getCardValue(i))
				return GameResult.ENEMY_WON;
		}
		return GameResult.DRAW;
	}

	private static GameResult resolvePairDraw(IHand player, IHand enemy) {
		int result = compareMultipleCardValues(player, enemy, 2);
		if (result == 1)
			return GameResult.PLAYER_WON;
		if (result == 2)
			return GameResult.ENEMY_WON;
		return iterateThroughRestValues(player, enemy, 0);
	}

	private static GameResult resolveTwoPairDraw(IHand player, IHand enemy) {
		Map<Integer, Integer> playerMatcher = player.getMap();
		Map<Integer, Integer> enemyMatcher = enemy.getMap();
		List<Integer> playerPairValues = new ArrayList<>();
		List<Integer> enemyPairValues = new ArrayList<>();

		for (Entry<Integer, Integer> entry : playerMatcher.entrySet())
			if (entry.getValue() == 2)
				playerPairValues.add(entry.getKey());

		for (Entry<Integer, Integer> entry : enemyMatcher.entrySet()) {
			if (entry.getValue() == 2)
				enemyPairValues.add(entry.getKey());
		}

		for (int i = 1; i >= 0; i--) {
			if (playerPairValues.get(i) > enemyPairValues.get(i))
				return GameResult.PLAYER_WON;
			if (playerPairValues.get(i) < enemyPairValues.get(i))
				return GameResult.ENEMY_WON;
		}

		return iterateThroughRestValues(player, enemy, 0);
	}

	private static GameResult resolveThreeOfAKindDraw(IHand player, IHand enemy) {
		int result = compareMultipleCardValues(player, enemy, 3);
		if (result == 1)
			return GameResult.PLAYER_WON;
		if (result == 2)
			return GameResult.ENEMY_WON;
		return iterateThroughRestValues(player, enemy, 0);
	}

	private static GameResult compareHighestCards(IHand player, IHand enemy) {
		int playerHighestValue = player.getHighestValue();
		int enemyHighestValue = enemy.getHighestValue();

		if (playerHighestValue > enemyHighestValue)
			return GameResult.PLAYER_WON;
		if (playerHighestValue < enemyHighestValue)
			return GameResult.ENEMY_WON;
		return GameResult.DRAW;
	}

	private static GameResult resolveFourOfAKindDraw(IHand player, IHand enemy) {
		int result = compareMultipleCardValues(player, enemy, 4);
		if (result == 1)
			return GameResult.PLAYER_WON;
		if (result == 2)
			return GameResult.ENEMY_WON;
		return iterateThroughRestValues(player, enemy, 0);
	}

	private static GameResult resolveFullDraw(IHand player, IHand enemy) {
		int result = compareMultipleCardValues(player, enemy, 3);
		if (result == 1)
			return GameResult.PLAYER_WON;
		if (result == 2)
			return GameResult.ENEMY_WON;

		result = compareMultipleCardValues(player, enemy, 2);
		if (result == 1)
			return GameResult.PLAYER_WON;
		if (result == 2)
			return GameResult.ENEMY_WON;
		return iterateThroughRestValues(player, enemy, 0);
	}

	private static int compareMultipleCardValues(IHand player, IHand enemy,
			int frequency) {
		Map<Integer, Integer> playerMatcher = player.getMap();
		Map<Integer, Integer> enemyMatcher = enemy.getMap();
		int playerPairValue = 0;
		int enemyPairValue = 0;

		for (Entry<Integer, Integer> entry : playerMatcher.entrySet())
			if (entry.getValue() == frequency)
				playerPairValue = entry.getKey();

		for (Entry<Integer, Integer> entry : enemyMatcher.entrySet()) {
			if (entry.getValue() == frequency)
				enemyPairValue = entry.getKey();
		}

		if (playerPairValue > enemyPairValue)
			return 1;
		if (playerPairValue < enemyPairValue)
			return 2;

		return 0;
	}
}