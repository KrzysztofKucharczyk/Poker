
public class CardValue {
	private int value;

	public CardValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return new String(new Integer(getValue()).toString());
	}
	
	public static int convertValueString(String value) {
		if(value.equals("T"))
				return 10;
		else if(value.equals("J"))
			return 11;
		else if(value.equals("Q"))
			return 12;
		else if(value.equals("K"))
			return 13;
		else if(value.equals("A"))
			return 14;
		else 
			return new Integer(value);
		
	}
}
