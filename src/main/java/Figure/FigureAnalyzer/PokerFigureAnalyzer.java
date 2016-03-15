package Figure.FigureAnalyzer;
import java.util.ArrayList;
import java.util.List;

import Figure.FigureAnalyzer.MultipleCardAnalyzer.MultipleCardAnalyzer;
import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.FigureOrganiser.PokerFigureOrganiser;
import Figure.Model.Figure;
import Figure.Model.FigureName;
import Hand.IHand;

public class PokerFigureAnalyzer implements IFigureAnalyzer {

	private List<IFiguresOrganiser> figureList = new ArrayList<>();
	private IHand hand;

	// ---------------------------------------------------------

	public PokerFigureAnalyzer(IHand hand) {
		this.hand = hand;
		hand.setFigureAnalyzer(this);
	}

	// ---------------------------------------------------------
	
	@Override
	public List<IFiguresOrganiser> getFigureOrganisers() {
		return figureList;
	}

	@Override
	public void addFigure(IFiguresOrganiser newFigureOrganiser) {
		figureList.add((PokerFigureOrganiser) newFigureOrganiser);
	}
	
	@Override
	public Figure getFigure() {
		figureList = MultipleCardAnalyzer.anayzeFrequencies(hand);

		if (isPoker()) {
			if (isRoyalPoker())
				return new Figure(FigureName.ROYAL_FLUSH, 10);
			return new Figure(FigureName.STRAIGHT_FLUSH, 9);
		}

		else if (isFourOfAKind())
			return new Figure(FigureName.FOUR_OF_A_KIND, 8);

		else if (isFull())
			return new Figure(FigureName.FULL, 7);

		else if (isFlush())
			return new Figure(FigureName.FLUSH, 6);

		else if (isStraight())
			return new Figure(FigureName.STRAIGHT, 5);

		else if (areThreeOfAKind())
			return new Figure(FigureName.THREE_OF_A_KIND, 4);

		else if (areTwoPairs())
			return new Figure(FigureName.TWO_PAIRS, 3);

		else if (isPair())
			return new Figure(FigureName.PAIR, 2);
		else
			return new Figure(FigureName.HIGH_CARD, 1);
	}
	
	private boolean isPair() {
		return figureList.get(figureList.size()-1).getCardFrequency() == 2;
	}

	private boolean areTwoPairs() {
		return (figureList.get(figureList.size()-1).getCardValues().size() == 2);
	}

	private boolean areThreeOfAKind() {
		return figureList.get(figureList.size()-1).getCardFrequency() == 3;
	}

	private boolean isStraight() {
		for (int i = 1; i < hand.getCardsList().size(); i++)
			if (hand.getCardValue(i - 1) + 1 != (hand.getCardValue(i)))
				return false;

		return true;
	}

	private boolean isFlush() {
		for (int i = 1; i < hand.getCardsList().size(); i++)
			if (!hand.getCardColor(i - 1).equals(hand.getCardColor(i)))
				return false;
		return true;
	}

	private boolean isFull() {
		return (figureList.size() == 2) && (figureList.get(0).getCardFrequency() == 2 && figureList.get(1).getCardFrequency() == 3);
	}

	private boolean isFourOfAKind() {
		return (figureList.get(figureList.size()-1).getCardFrequency() == 4);
	}

	private boolean isPoker() {
		return isStraight() && isFlush();
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
