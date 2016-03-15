package Figure.FigureAnalyzer;

import java.util.List;

import Figure.FigureOrganiser.IFiguresOrganiser;
import Figure.Model.Figure;

public interface IFigureAnalyzer {

	public Figure getFigure();

	public List<IFiguresOrganiser> getFigureOrganisers();

	public void addFigure(IFiguresOrganiser newFigureOrganiser);
}
