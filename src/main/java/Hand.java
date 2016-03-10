import java.util.List;

public interface Hand {

	public List<PlayingCard> getHand();

	public int getCardValue(int index);
	
	public List<Integer> getCardsValues();
	
	public Color getCardColor(int index);
	
	public int getLastCard();

	public void clear();
	
	public FigureAnalyzer getFigureAnalyzer();
	
	public void setFigureAnalyzer(FigureAnalyzer figureAnalyzer);
}
