package Counter;
public class WinCounter implements ICounter{
	private int points = 0;
	
	@Override
	public int getPoints() {
		return points;
	}
	
	@Override
	public void addPoint() {
		points++;
	}
}
