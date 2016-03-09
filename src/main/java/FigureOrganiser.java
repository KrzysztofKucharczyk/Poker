import java.util.ArrayList;
import java.util.Collection;

public class FigureOrganiser implements Comparable<FigureOrganiser> {
	private int frequency;
	private Collection<Integer> cardValues = new ArrayList<Integer>();

	// ---------------------------------------------------------

	public FigureOrganiser(int frequency, Integer cardValue) {
		this.frequency = frequency;
		this.cardValues.add(cardValue);
	}

	// ---------------------------------------------------------

	public int getFrequency() {
		return frequency;
	}

	public Collection<Integer> getCardValues() {
		return cardValues;
	}

	@Override
	public String toString() {
		String result = new String();

		result = "[" + frequency + "," + cardValues + "]\n";
		return result;
	}

	public int compareTo(FigureOrganiser another) {
		return this.frequency > another.frequency ? 1 : -1;
	}
}