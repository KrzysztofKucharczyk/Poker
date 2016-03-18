package Hand;

import java.util.List;

import CardModel.Color;
import CardModel.ICard;
import Figure.FigureAnalyzer.IFigureAnalyzer;
import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.Model.IFigure;

public interface IHand {

	public List<ICard> getCardsList();

	public int getCardValue(int index);
	
	public List<Integer> getCardsValues();
	
	public Color getCardColor(int index);
	
	public int getHighestValue();
	
	public IFigureAnalyzer getFigureAnalyzer();
	
	public List<IFiguresOrganiser>  getFigureOrganisers();
	
	public IFigure getFigure();
	
	public void setFigureAnalyzer(IFigureAnalyzer figureAnalyzer);

	int getCardValueFromGivenFigureOrganiser(int figureOrganiserNumber, int argument);
}
