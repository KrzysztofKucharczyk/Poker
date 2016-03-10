import java.util.List;

public interface IFiguresOrganiserList {
	
	public int getCardFrequency(int index);
	
	public int getFrequencyOfLastElement();
	
	public List<Integer> getCardValuesOfLastElement();
	
	public void addFigure(IFiguresOrganiser newFigureOrganiser);
	
	public int size();
	
	public List<IFiguresOrganiser> getFiguresList();
}
