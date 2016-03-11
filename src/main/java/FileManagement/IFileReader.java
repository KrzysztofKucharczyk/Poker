package FileManagement;
import Hand.IHand;

public interface IFileReader {
	
	public IHand getNewHand();
	
	public boolean nextLine();
	
	public void closeInputStream();
}
