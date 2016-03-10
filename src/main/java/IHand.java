
import java.util.List;

public interface IHand {

	public List<ICard> getCardsList();

	public int getCardValue(int index);
	
	public List<Integer> getCardsValues();
	
	public Color getCardColor(int index);
	
	public int getLastCardValue();

	public void clear();
	
	public IFigureAnalyzer getFigureAnalyzer();
	
	public void setFigureAnalyzer(IFigureAnalyzer figureAnalyzer);

	int getCardValueFromGivenFigureOrganiser(int figureOrganiserNumber, int argument);
}
