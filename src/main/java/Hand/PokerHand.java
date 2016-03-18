package Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CardModel.Color;
import CardModel.ICard;
import Figure.FigureAnalyzer.IFigureAnalyzer;
import Figure.FigureAnalyzer.PokerFigureAnalyzer;
import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.Model.IFigure;

public class PokerHand implements IHand {
	private final List<ICard> hand;
	private IFigureAnalyzer figureAnalyzer = new PokerFigureAnalyzer(this);

	public PokerHand(List<ICard> cards) {
		this.hand = Collections.unmodifiableList(sort(cards));
	}

	@Override
	public IFigureAnalyzer getFigureAnalyzer() {
		return figureAnalyzer;
	}

	public List<ICard> getCardsList() {
		return hand;
	}

	public String toString() {
		String result = hand.get(0).toString();
		for (int i = 1; i < hand.size(); i++)
			result += " " + hand.get(i).toString();
		return result;
	}

	private List<ICard> sort(List<ICard> cards) {
		Collections.sort(cards);
		return cards;
	}

	@Override
	public int getCardValue(int index) {
		return getCardsList().get(index).getValue();
	}

	@Override
	public int getHighestValue() {
		return hand.get(hand.size() - 1).getValue();
	}

	@Override
	public Color getCardColor(int index) {
		return hand.get(index).getColor();
	}

	@Override
	public List<Integer> getCardsValues() {
		List<Integer> result = new ArrayList<Integer>();

		for (ICard card : hand)
			result.add(card.getValue());

		return result;
	}

	@Override
	public void setFigureAnalyzer(IFigureAnalyzer figureAnalyzer) {
		this.figureAnalyzer = figureAnalyzer;
	}

	@Override
	public int getCardValueFromGivenFigureOrganiser(int figureOrganiserNumber, int argument) {
		return this.getFigureAnalyzer().getFigureOrganisers().get(figureOrganiserNumber)
				.getCardValues().get(argument);
	}

	@Override
	public List<IFiguresOrganiser> getFigureOrganisers() {
		return getFigureAnalyzer().getFigureOrganisers();
	}

	@Override
	public IFigure getFigure() {
		return getFigureAnalyzer().getFigure();
	}
}
