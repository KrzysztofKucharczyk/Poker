package Figure.FigureAnalyzer;

import Figure.FiguresOrganiserList.IFiguresOrganiserList;
import Figure.Model.Figure;

public interface IFigureAnalyzer {
	
	public IFiguresOrganiserList getFigureOrganisersList();

	public Figure getFigure();
}
