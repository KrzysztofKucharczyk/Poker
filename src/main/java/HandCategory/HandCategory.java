package HandCategory;


public class HandCategory {
	private HandCategoryName name;
	private int value;
	
	public HandCategory(HandCategoryName name, int value) {
		this.name = name;
		this.value = value;
	}

	public HandCategoryName getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
}
