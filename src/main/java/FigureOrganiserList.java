import java.util.List;

public interface FigureOrganiserList {
	
	public int getCardFrequency(int index);
	public int getFrequencyOfLastElement();
	public List<Integer> getCardValuesOfLastElement();
	public List<PokerFigureOrganiser> getFigureList();
	public void addFigure(FigureOrganiser newFigureOrganiser);
	public int size();
	public List<PokerFigureOrganiser> getFiguresList();
}
