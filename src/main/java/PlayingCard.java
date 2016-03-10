public class PlayingCard implements Card, Comparable<PlayingCard>{

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

	public int compareTo(PlayingCard other) {
		return (getValue() > other.getValue()) ? 1 : -1;
	}
}
