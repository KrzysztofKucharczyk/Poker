public class PokerFigureAnalyzer implements IFigureAnalyzer {

	private IFiguresOrganiserList figureList = new PokerFigureOrganiserList();
	private IHand hand;

	// ---------------------------------------------------------

	public PokerFigureAnalyzer(IHand hand) {
		this.hand = hand;
	}

	// ---------------------------------------------------------
	
	@Override
	public IFiguresOrganiserList getFigureOrganisersList() {
		return figureList;
	}

	@Override
	public Figure getFigure(IHand hand) {
		MultipleCardAnalyzer.anayzeMultipleCards(hand, figureList);
		hand.setFigureAnalyzer(this);

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
		return figureList.getFrequencyOfLastElement() == 2 ? true : false;
	}

	private boolean areTwoPairs() {
		return (figureList.getCardValuesOfLastElement().size() == 2) ? true : false;
	}

	private boolean areThreeOfAKind() {
		return figureList.getFrequencyOfLastElement() == 3 ? true : false;
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
		return (figureList.size() == 2) && (figureList.getCardFrequency(0) == 2 && figureList.getCardFrequency(1) == 3)
				? true : false;
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
