package CardModel;
public class PlayingCard implements ICard, Comparable<ICard>{

	private CardValue value;
	private CardColor color;
	
	// --------------------------------------------
	
	public PlayingCard(int value, Color color) {
		this.value = new CardValue(value); 
		this.color = new CardColor(color);
	}

	// --------------------------------------------
	
	public int getValue() {
		return value.getValue();
	}

	public Color getColor() {
		return color.getColor();
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
