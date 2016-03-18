package CardModel;
public class PlayingCard implements ICard, Comparable<ICard>{

	private int value;
	private Color color;
	
	// --------------------------------------------
	
	public PlayingCard(int value, Color color) {
		this.value = value; 
		this.color = color;
	}

	// --------------------------------------------
	
	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public String toString() {
		return value + "" + color;
	}

	public int compareTo(ICard other) {
		return getValue() - other.getValue();
	}
}
