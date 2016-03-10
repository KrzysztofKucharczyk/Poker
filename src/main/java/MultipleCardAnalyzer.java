import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultipleCardAnalyzer {

	private static boolean isAnythingAdded = false;
	private static boolean isOnListInFigureOrganiser = false;

	private static Collection<Integer> getFrequenciesOfCardValues(IHand hand) {
		List<Integer> frequencies = new ArrayList<Integer>();
		for (Integer cardValue : hand.getCardsValues())
			frequencies.add(Collections.frequency(hand.getCardsValues(), cardValue));
		return frequencies;
	}

	public static void anayzeMultipleCards(IHand hand, IFiguresOrganiserList figureList) {

		List<Integer> frequencies = (ArrayList<Integer>) getFrequenciesOfCardValues(hand);

		for (int i = 0; i < frequencies.size(); i++) {
			isAnythingAdded = false;
			isOnListInFigureOrganiser = false;

			for (IFiguresOrganiser figureOrganiser : figureList.getFiguresList()) {

				if (frequencies.get(i) == figureOrganiser.getCardFrequency()) {

					for (Integer cardValue : figureOrganiser.getCardValues()) {

						if (hand.getCardValue(i) == cardValue) {

							isOnListInFigureOrganiser = true;
							isAnythingAdded = true;
						}
					}

					if (!isOnListInFigureOrganiser) {
						figureOrganiser.getCardValues().add(hand.getCardValue(i));
						isAnythingAdded = true;
					}
				}
			}
			if (!isAnythingAdded)
				figureList.addFigure(new PokerFigureOrganiser(frequencies.get(i), hand.getCardValue(i)));

		}
		
		Collections.sort(figureList.getFiguresList());
	}

}
