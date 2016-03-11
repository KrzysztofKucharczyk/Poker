package Figure.FigureOrganiser;
import java.util.List;

public interface IFiguresOrganiser extends Comparable<IFiguresOrganiser>{
	
	public int getCardFrequency();
	
	public List<Integer> getCardValues();
}
