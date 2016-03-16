package DrawResolver;

import java.util.ArrayList;

import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.Model.FigureName;
import Hand.IHand;

public class DrawResolver {

	public static int resolve(IHand player, IHand enemy) {
		FigureName figureName = player.getFigure().getFigureName();

		// straight flushes and royal flushes always results in draw
		if (figureName == FigureName.ROYAL_FLUSH)
			return 0;
		if (figureName == FigureName.STRAIGHT_FLUSH)
			return 0;
		if (figureName == FigureName.FOUR_OF_A_KIND || figureName == FigureName.THREE_OF_A_KIND
				|| figureName == FigureName.FULL)
			return resolveSimilarCases(player, enemy, 1);
		if (figureName == FigureName.TWO_PAIRS)
			return resolveSimilarCases(player, enemy, 2);
		if (figureName == FigureName.PAIR)
			return resolvePairConflict(player, enemy);
		// includes FLUSH and HIGH_CARD
		return iterateThroughRestValues(player, enemy) ? 1 : 2;
	}

	// Applies for FOUR_OF_A_KIND, THRE__OF_A_KIND, FULL and TWO_PAIRS
	private static int resolveSimilarCases(IHand player, IHand enemy, int startingPoint) {
		int playerStrength;
		int enemyStrength;

		for (int i = startingPoint; i >= 0; i--) {
			playerStrength = player.getCardValueFromGivenFigureOrganiser(i, 0);
			enemyStrength = enemy.getCardValueFromGivenFigureOrganiser(i, 0);

			if (playerStrength > enemyStrength)
				return 1;
			else if (playerStrength < enemyStrength)
				return 2;
		}
		return 0;
	}

	private static int resolvePairConflict(IHand player, IHand enemy) {
		int hand1Value = getValueOfPair(player);
		int hand2Value = getValueOfPair(enemy);

		return (hand1Value > hand2Value) ? 1 : 2;
	}

	private static int getValueOfPair(IHand hand) {
		int result = 0;
		for (IFiguresOrganiser figureOrganiser : hand.getFigureOrganisers())
			if (figureOrganiser.getCardFrequency() == 2)
				result = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);
		return result;
	}

	private static boolean iterateThroughRestValues(IHand hand1, IHand hand2) {
		for (int i = hand1.getCardsList().size() - 1; i > 0; i--) {
			if (hand1.getCardValue(i) > hand2.getCardValue(i))
				return true;
			else if (hand1.getCardValue(i) < hand2.getCardValue(i))
				return false;
		}
		return false;
	}
}
