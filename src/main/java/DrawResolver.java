import java.util.ArrayList;

public class DrawResolver {

	public static int resolve(Hand hand1, Hand hand2) {
		int value = hand1.getStrength();

		switch (value) {
		case 9: {
			return iterateThroughRestValues(hand1, hand2) ? 1 : -1;
		}
		case 8: {
		}
		case 7: {

		}
		case 6: {
			return iterateThroughRestValues(hand1, hand2) ? 1 : -1;
		}
		case 5: {
			return iterateThroughRestValues(hand1, hand2) ? 1 : -1;
		}
		case 4: {

		}
		case 3: {

		}
		case 2: {
			int hand1Value = 0;
			int hand2Value = 0;

			for (FigureOrganiser figureOrganiser : hand1.getFigureAnalizer().getData())
				if (figureOrganiser.getFrequency() == 2)
					hand1Value = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);

			for (FigureOrganiser figureOrganiser : hand2.getFigureAnalizer().getData())
				if (figureOrganiser.getFrequency() == 2)
					hand2Value = ((ArrayList<Integer>) figureOrganiser.getCardValues()).get(0);

			return (hand1Value > hand2Value) ? 1 : -1;
		}

		case 1: {
			return iterateThroughRestValues(hand1, hand2) ? 1 : -1;
		}

		}
		return 0;

	}

	private static boolean iterateThroughRestValues(Hand hand1, Hand hand2) {
		for (int i = Hand.size() - 1; i > 0; i--) {
			if (hand1.getValue(i) > hand2.getValue(i))
				return true;
			else if (hand1.getValue(i) < hand2.getValue(i))
				return false;
		}

		return false;
	}
}
