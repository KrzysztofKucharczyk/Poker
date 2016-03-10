import java.util.ArrayList;
import java.util.List;

public class PokerFigureOrganiserList implements FigureOrganiserList{
	private List<PokerFigureOrganiser> figuresList =  new ArrayList<PokerFigureOrganiser>();

	@Override
	public int getFrequencyOfLastElement() {
		return figuresList.get(figuresList.size()-1).getCardFrequency(); 
	}

	@Override
	public List<PokerFigureOrganiser> getFigureList() {
		return figuresList;
	}

	@Override
	public void addFigure(FigureOrganiser newFigureOrganiser) {
		figuresList.add((PokerFigureOrganiser) newFigureOrganiser);
	}

	@Override
	public int size() {
		return figuresList.size();
	}

	@Override
	public List<Integer> getCardValuesOfLastElement() {
		return figuresList.get(size()-1).getCardValues();
	}

	@Override
	public int getCardFrequency(int index) {
		return figuresList.get(index).getCardFrequency();
	}
	
	@Override
	public List<PokerFigureOrganiser> getFiguresList() {
		return figuresList;
	}
	
	
}
