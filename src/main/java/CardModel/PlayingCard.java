package CardModel;
public class PlayingCard implements ICard, Comparable<ICard>{

	private int value;
	private Suite suite;
	
	// --------------------------------------------
	
	public PlayingCard(int value, Suite suite) {
		this.value = value; 
		this.suite = suite;
	}

	// --------------------------------------------
	
	public int getValue() {
		return value;
	}

	public Suite getSuite() {
		return suite;
	}

	public String toString() {
		return value + "" + suite;
	}

	public int compareTo(ICard other) {
		return getValue() - other.getValue();
	}
}
