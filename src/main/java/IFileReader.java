public interface IFileReader {
	
	public IHand getNewHand();
	
	public boolean nextLine();
	
	public void closeInputStream();
}
