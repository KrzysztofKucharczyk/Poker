import java.util.ArrayList;

public class DrawResolver {

	public static int resolve(IHand player, IHand enemy) {
		FigureName figureName = player.getFigureAnalyzer().getFigure(player).getFigureName();

		if (figureName == FigureName.ROYAL_FLUSH)
			return 0;
		else if (figureName == FigureName.STRAIGHT_FLUSH)
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		else if (figureName == FigureName.FOUR_OF_A_KIND)
			return resolveFourOfAKind(player, enemy);
		else if (figureName == FigureName.FULL)
			return resolveFullConflict(player, enemy);
		else if (figureName == FigureName.FLUSH)
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		else if (figureName == FigureName.STRAIGHT)
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		else if (figureName == FigureName.THREE_OF_A_KIND)
			return resolveThreeOfAKindConflict(player, enemy);
		else if (figureName == FigureName.TWO_PAIRS)
			return resolveTwoPairsConflict(player, enemy);
		else if (figureName == FigureName.PAIR)
			return resolvePairConflict(player, enemy);
		else
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
	}

	private static int resolveFourOfAKind(IHand player, IHand enemy) {
		int playerStrength;
		int enemyStrength;

		for (int i = 1; i >= 0; i--) {
			playerStrength = player.getCardValueFromGivenFigureOrganiser(i, 0);
			enemyStrength = enemy.getCardValueFromGivenFigureOrganiser(i, 0);

			if (playerStrength > enemyStrength)
				return 1;
			else if (playerStrength < enemyStrength)
				return 2;
		}
		return 0;
	}

	private static int resolveThreeOfAKindConflict(IHand player, IHand enemy) {
		int playerStrength;
		int enemyStrength;

		for (int i = 1; i >= 0; i--) {
			playerStrength = player.getCardValueFromGivenFigureOrganiser(i, 0);
			enemyStrength = enemy.getCardValueFromGivenFigureOrganiser(i, 0);

			if (playerStrength > enemyStrength)
				return 1;
			else if (playerStrength < enemyStrength)
				return 2;
		}
		return 0;
	}

	private static int resolveFullConflict(IHand player, IHand enemy) {
		int playerStrength;
		int enemyStrength;

		for (int i = 1; i >= 0; i--) {
			playerStrength = player.getCardValueFromGivenFigureOrganiser(i, 0);
			enemyStrength = enemy.getCardValueFromGivenFigureOrganiser(i, 0);

			if (playerStrength > enemyStrength)
				return 1;
			else if (playerStrength < enemyStrength)
				return 2;
		}
		return 0;
	}

	private static int resolveTwoPairsConflict(IHand player, IHand enemy) {
		int playerStrength;
		int enemyStrength;

		for (int i = 2; i >= 0; i--) {
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
		int hand1Value = 0;
		int hand2Value = 0;

		for (IFiguresOrganiser figureOrganiser : player.getFigureAnalyzer().getFigureOrganisersList().getFiguresList())
			if (figureOrganiser.getCardFrequency() == 2)
				hand1Value = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);

		for (IFiguresOrganiser figureOrganiser : enemy.getFigureAnalyzer().getFigureOrganisersList().getFiguresList())
			if (figureOrganiser.getCardFrequency() == 2)
				hand2Value = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);

		return (hand1Value > hand2Value) ? 1 : 2;
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
