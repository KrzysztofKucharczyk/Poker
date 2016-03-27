package CardModel;

public interface ICard extends Comparable<ICard>{
	public int getValue();
	public Suite getSuite();
	
}
