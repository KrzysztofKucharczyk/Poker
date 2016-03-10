import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand implements Hand {
	private List<PlayingCard> hand = new ArrayList<>();
	private FigureAnalyzer	figureAnalyzer = new FigureAnalyzer(this);
	
	public PokerHand(List<PlayingCard> cards) {
		this.hand = cards;
		sort();
	}

	@Override
	public FigureAnalyzer getFigureAnalyzer() {
		return figureAnalyzer;
	}

	public List<PlayingCard> getHand() {
		return hand;
	}

	public String toString() {
		String result = "";
		for (PlayingCard card : hand)
			result += card + " ";
		return result;
	}

	private void sort() {
		Collections.sort(hand);
	}

	@Override
	public int getCardValue(int index) {
		return getHand().get(index).getValue();
	}

	@Override
	public int getLastCard() {
		return hand.get(hand.size()-1).getValue();
	}

	@Override
	public Color getCardColor(int index) {
		return hand.get(index).getColor();
	}

	@Override
	public List<Integer> getCardsValues() {
		List<Integer> result = new ArrayList<Integer>();
		
		for(Card card : hand)
			result.add(card.getValue());
		
		return result;
	}
	

	@Override
	public void clear() {
		hand.clear();
		
	}
	
	@Override
	public void setFigureAnalyzer(FigureAnalyzer figureAnalyzer) {
		this.figureAnalyzer = figureAnalyzer;
	}
}
