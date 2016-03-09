import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Hand {

	private static int size = 5;
	private List<Integer> values = new ArrayList<Integer>();
	private List<String> colors = new ArrayList<String>();
	private FigureAnalyzer figureAnalyzer = new FigureAnalyzer(this);
	private int points = 0;

	// ---------------------------------------------------------

	public Hand() {
	}

	public Hand(ArrayList<Integer> values, ArrayList<String> colors) {
		this.values = values;
		this.colors = colors;
	}

	// ---------------------------------------------------------

	public static int size() {
		return size;
	}

	public int getValue(int index) {
		return values.get(index);
	}

	public String getColor(int index) {
		return colors.get(index);
	}

	public Collection<Integer> getValues() {
		return values;
	}

	public FigureAnalyzer getFigureAnalizer() {
		return figureAnalyzer;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public String toString() {
		String result = new String();
		result = values.get(0).toString() + colors.get(0);
		for (int i = 1; i < size(); i++)
			result += " " + values.get(i) + colors.get(i);
		return result;
	}

	// ---------------------------------------------------------

	public void divideStringCard(ArrayList<String> list) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayList<String> colors = new ArrayList<String>();

		for (String card : list) {
			values.add(Hand.convertCardValuesFromString(card.substring(0, 1)));
			colors.add(card.substring(1, 2));
		}

		this.values = values;
		this.colors = colors;

	}

	public static int convertCardValuesFromString(String value) {
		if (value.equals("T"))
			return 10;
		if (value.equals("J"))
			return 11;
		if (value.equals("Q"))
			return 12;
		if (value.equals("K"))
			return 13;
		if (value.equals("A"))
			return 14;
		else
			return new Integer(value);
	}

	public void sort() {
		Collections.sort(values);
	}

	public void addPoint() {
		points++;
	}

	public int getStrength() {
		return figureAnalyzer.getFigureStrength();
	}

	public void clearAll() {
		values.clear();
		colors.clear();
		figureAnalyzer = new FigureAnalyzer(this);
	}

}
