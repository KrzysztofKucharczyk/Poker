package CardModel;


public class CardColor {
	private Color color;

	public CardColor(Color color) {
		this.color = color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public String toString() {
		return new String(getColor().toString());
	}

	public static Color convertColorString(String color) {
		if (color.equals("D"))
			return Color.D;
		else if (color.equals("S"))
			return Color.S;
		else if (color.equals("H"))
			return Color.H;
		else
			return Color.C;
	}
}
