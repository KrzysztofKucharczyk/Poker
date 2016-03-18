package Figure.FigureOrganiser;
import java.util.ArrayList;
import java.util.List;

// RENAME!!! Group card?
public class PokerFigureOrganiser implements IFiguresOrganiser {
	private int frequency;
	private List<Integer> cardValues = new ArrayList<Integer>();

	// ---------------------------------------------------------

	public PokerFigureOrganiser(int frequency, Integer cardValue) {
		this.frequency = frequency;
		this.cardValues.add(cardValue);
	}

	// ---------------------------------------------------------
	
	@Override
	public int getCardFrequency() {
		return frequency;
	}

	@Override
	public List<Integer> getCardValues() {
		return cardValues;
	}

	@Override
	public String toString() {
		return "[" + frequency + "," + cardValues + "]\n";
	}

	@Override
	public int compareTo(IFiguresOrganiser another) {
		return this.getCardFrequency() > another.getCardFrequency() ? 1 : -1;
	}
}