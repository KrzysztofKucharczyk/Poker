package Figure.FigureAnalyzer.MultipleCardAnalyzer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.FigureOrganiser.PokerFigureOrganiser;
import Hand.IHand;

public class MultipleCardAnalyzer {

	private static boolean isAnythingAdded = false;
	private static boolean isOnListInFigureOrganiser = false;

	private static Collection<Integer> getFrequenciesOfCardValues(IHand hand) {
		List<Integer> frequencies = new ArrayList<Integer>();
		for (Integer cardValue : hand.getCardsValues())
			frequencies.add(Collections.frequency(hand.getCardsValues(), cardValue));
		return frequencies;
	}

	public static List<IFiguresOrganiser> anayzeFrequencies(IHand hand) {

		List<Integer> frequencies = (ArrayList<Integer>) getFrequenciesOfCardValues(hand);

		for (int i = 0; i < frequencies.size(); i++) {
			isAnythingAdded = false;
			isOnListInFigureOrganiser = false;

			for (IFiguresOrganiser figureOrganiser : hand.getFigureAnalyzer().getFigureOrganisers()) {

				if (frequencies.get(i) == figureOrganiser.getCardFrequency()) {

					for (Integer cardValue : figureOrganiser.getCardValues())

						if (hand.getCardValue(i) == cardValue) {

							isOnListInFigureOrganiser = true;
							isAnythingAdded = true;
						}

					if (!isOnListInFigureOrganiser) {
						figureOrganiser.getCardValues().add(hand.getCardValue(i));
						isAnythingAdded = true;
					}
				}
			}
			if (!isAnythingAdded)
				hand.getFigureAnalyzer().addFigure(new PokerFigureOrganiser(frequencies.get(i), hand.getCardValue(i)));

		}

		Collections.sort(hand.getFigureAnalyzer().getFigureOrganisers());
		return hand.getFigureAnalyzer().getFigureOrganisers();
	}

}
