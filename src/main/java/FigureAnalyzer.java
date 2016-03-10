import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FigureAnalyzer {

	private PokerFigureOrganiserList figureList = new PokerFigureOrganiserList();
	private Hand hand;

	// ---------------------------------------------------------
	
	public FigureAnalyzer(Hand hand) {
		this.hand = hand;
	}

	// ---------------------------------------------------------

	private Collection<Integer> getFrequenciesOfCardValues(Hand hand) {
		ArrayList<Integer> frequencies = new ArrayList<Integer>();
		for (int i = 0; i < hand.getHand().size(); i++)
			frequencies.add(Collections.frequency(hand.getCardsValues(),
					hand.getCardValue(i)));
		return frequencies;
	}

	// ---------------------------------------------------------
	
	public  FigureOrganiserList getFigureList() {
		return figureList;
	}
	
	public int getFigureStrength(Hand hand) {
		anayzeMultipleCards(hand);
		hand.setFigureAnalyzer(this);
		
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

	public void anayzeMultipleCards(Hand hand) {

		boolean isAnythingAdded = false;
		boolean isOnListInFigureOrganiser = false;
		ArrayList<Integer> frequencies = (ArrayList<Integer>) getFrequenciesOfCardValues(hand);

		for (int i = 0; i < frequencies.size(); i++) {
			isAnythingAdded = false;
			isOnListInFigureOrganiser = false;

			for (FigureOrganiser figureOrganiser : figureList.getFigureList()) {
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
				figureList.addFigure(new PokerFigureOrganiser(frequencies.get(i), hand
						.getCardValue(i)));

		}
		Collections.sort(figureList.getFigureList());
	}

	private boolean isPair() {
		return figureList.getFrequencyOfLastElement() == 2 ? true : false;
	}

	private boolean areTwoPairs() {
		return (figureList.getCardValuesOfLastElement().size() == 2) ? true
				: false;
	}

	private boolean areThreeOfAKind() {
		return figureList.getFrequencyOfLastElement() == 3 ? true : false;
	}

	private boolean isStraight() {
		for (int i = 1; i < hand.getHand().size(); i++)
			if (hand.getCardValue(i - 1) + 1 != (hand.getCardValue(i)))
				return false;

		return true;
	}

	private boolean isFlush() {
		for (int i = 1; i < hand.getHand().size(); i++)
			if (!hand.getCardColor(i - 1).equals(hand.getCardColor(i)))
				return false;
		return true;
	}

	private boolean isFull() {
		return (figureList.size() == 2)
				&& (figureList.getCardFrequency(0) == 2 && figureList.getCardFrequency(1) == 3) ? true : false;
	}

	private boolean isFourOfAKind() {
		return (figureList.getFrequencyOfLastElement() == 4) ? true : false;
	}

	private boolean isPoker() {
		return isStraight() && isFlush() ? true : false;
	}

	private boolean isRoyalPoker() {
		if (!isFlush())
			return false;

		int firstValue = 10;
		for (Integer cardValue : hand.getCardsValues())
			if (cardValue != firstValue++)
				return false;
		return true;
	}
}
