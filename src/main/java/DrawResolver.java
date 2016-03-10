import java.util.ArrayList;

public class DrawResolver {

	public static int resolve(Hand player, Hand enemy) {
		int value = player.getFigureAnalyzer().getFigureStrength(player);

		switch (value) {
		case 9: {
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		}
		case 8: {
		}
		case 7: {

		}
		case 6: {
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		}
		case 5: {
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		}
		case 4: {

		}
		case 3: {

		}
		case 2: {
			int hand1Value = 0;
			int hand2Value = 0;

			for (FigureOrganiser figureOrganiser : player.getFigureAnalyzer().getFigureList().getFiguresList())
				if (figureOrganiser.getCardFrequency() == 2)
					hand1Value = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);

			for (FigureOrganiser figureOrganiser : enemy.getFigureAnalyzer().getFigureList().getFiguresList())
				if (figureOrganiser.getCardFrequency() == 2)
					hand2Value = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);

			return (hand1Value > hand2Value) ? 1 : 2;
		}

		case 1: {
			return iterateThroughRestValues(player, enemy) ? 1 : 2;
		}

		}
		return 0;

	}

	private static boolean iterateThroughRestValues(Hand hand1, Hand hand2) {
		for (int i = hand1.getHand().size() - 1; i > 0; i--) {
			if (hand1.getCardValue(i) > hand2.getCardValue(i))
				return true;
			else if (hand1.getCardValue(i) < hand2.getCardValue(i))
				return false;
		}

		return false;
	}
}
