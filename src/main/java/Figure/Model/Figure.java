package Figure.Model;

public class Figure implements IFigure {
	private FigureName figureName;
	private int figureValue;
	
	public Figure(FigureName figureName, int figureValue) {
		this.figureName = figureName;
		this.figureValue = figureValue;
	}

	public FigureName getFigureName() {
		return figureName;
	}

	public int getFigureValue() {
		return figureValue;
	}
}
