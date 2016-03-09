import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FigureAnalyzer {

	private Hand hand;
	private ArrayList<FigureOrganiser> data = new ArrayList<FigureOrganiser>();

	// ---------------------------------------------------------
	
	public FigureAnalyzer(Hand hand) {
		this.hand = hand;
	}

	// ---------------------------------------------------------
	
	public Collection<FigureOrganiser> getData() {
		return data;
	}

	private Collection<Integer> getFrequenciesOfCardValues() {
		ArrayList<Integer> frequencies = new ArrayList<Integer>();
		for (int i = 0; i < Hand.size(); i++)
			frequencies.add(Collections.frequency(hand.getValues(),
					hand.getValue(i)));
		return frequencies;
	}

	// ---------------------------------------------------------
	
	public int getFigureStrength() {
		anayzeMultipleCards();

		if (isPoker()) {
			if (isRoyalPoker())
				return 10;
			return 9;
		}

		else if (isFourOfAKind())
			return 8;

		else if (isFull())
			return 7;

		else if (isFlush())
			return 6;

		else if (isStraight())
			return 5;

		else if (areThreeOfAKind())
			return 4;

		else if (areTwoPairs())
			return 3;

		else if (isPair())
			return 2;
		else
			return 1;
	}

	public void anayzeMultipleCards() {

		boolean isAnythingAdded = false;
		boolean isOnListInFigureOrganiser = false;
		ArrayList<Integer> frequencies = (ArrayList<Integer>) getFrequenciesOfCardValues();

		for (int i = 0; i < frequencies.size(); i++) {
			isAnythingAdded = false;
			isOnListInFigureOrganiser = false;

			for (FigureOrganiser figureOrganiser : data) {
				if (frequencies.get(i) == figureOrganiser.getFrequency()) {
					for (Integer cardValue : figureOrganiser.getCardValues()) {
						if (hand.getValue(i) == cardValue) {
							isOnListInFigureOrganiser = true;
							isAnythingAdded = true;
						}
					}
					if (!isOnListInFigureOrganiser) {
						figureOrganiser.getCardValues().add(hand.getValue(i));
						isAnythingAdded = true;
					}
				}
			}
			if (!isAnythingAdded)
				data.add(new FigureOrganiser(frequencies.get(i), hand
						.getValue(i)));

		}
		Collections.sort(data);
	}

	private boolean isPair() {
		return data.get(data.size() - 1).getFrequency() == 2 ? true : false;
	}

	private boolean areTwoPairs() {
		return (data.get(data.size() - 1).getCardValues().size() == 2) ? true
				: false;
	}

	private boolean areThreeOfAKind() {
		return data.get(data.size() - 1).getFrequency() == 3 ? true : false;
	}

	private boolean isStraight() {
		for (int i = 1; i < Hand.size(); i++)
			if (hand.getValue(i - 1) + 1 != (hand.getValue(i)))
				return false;

		return true;
	}

	private boolean isFlush() {
		for (int i = 1; i < Hand.size(); i++)
			if (!hand.getColor(i - 1).equals(hand.getColor(i)))
				return false;
		return true;
	}

	private boolean isFull() {
		return (data.size() == 2)
				&& (data.get(0).getFrequency() == 2 && data.get(1)
						.getFrequency() == 3) ? true : false;
	}

	private boolean isFourOfAKind() {
		return (data.get(data.size() - 1).getFrequency() == 4) ? true : false;
	}

	private boolean isPoker() {
		return isStraight() && isFlush() ? true : false;
	}

	private boolean isRoyalPoker() {
		if (!isFlush())
			return false;

		int firstValue = 10;
		for (Integer cardValue : hand.getValues())
			if (cardValue != firstValue++)
				return false;
		return true;
	}
}
