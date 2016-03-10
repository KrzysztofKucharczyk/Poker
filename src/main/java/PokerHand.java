
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand implements IHand {
	private List<ICard> hand = new ArrayList<>();
	private IFigureAnalyzer figureAnalyzer = new PokerFigureAnalyzer(this);

	public PokerHand(List<ICard> cards) {
		this.hand = cards;
		sort();
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

	private void sort() {
		Collections.sort(hand);
	}

	@Override
	public int getCardValue(int index) {
		return getCardsList().get(index).getValue();
	}

	@Override
	public int getLastCardValue() {
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
	public void clear() {
		hand.clear();

	}

	@Override
	public void setFigureAnalyzer(IFigureAnalyzer figureAnalyzer) {
		this.figureAnalyzer = figureAnalyzer;
	}

	@Override
	public int getCardValueFromGivenFigureOrganiser(int figureOrganiserNumber, int argument) {
		return this.getFigureAnalyzer().getFigureOrganisersList().getFiguresList().get(figureOrganiserNumber)
				.getCardValues().get(argument);
	}
}
