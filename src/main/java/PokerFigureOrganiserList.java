import java.util.ArrayList;
import java.util.List;

public class PokerFigureOrganiserList implements IFiguresOrganiserList{
	private List<IFiguresOrganiser> figuresList =  new ArrayList<IFiguresOrganiser>();

	@Override
	public int getFrequencyOfLastElement() {
		return figuresList.get(figuresList.size()-1).getCardFrequency(); 
	}

	@Override
	public void addFigure(IFiguresOrganiser newFigureOrganiser) {
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
	public List<IFiguresOrganiser> getFiguresList() {
		return figuresList;
	}
	
	
}
