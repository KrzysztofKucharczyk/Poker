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
		return new String(value + "" + color);
	}

	public int compareTo(ICard other) {
		if(getValue() > other.getValue()) return 1;
		else if(getValue() < other.getValue()) return -1;
		else return 0;
	}
}
