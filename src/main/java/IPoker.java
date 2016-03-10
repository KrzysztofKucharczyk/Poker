
public interface IPoker {

	public boolean isInput();

	public void getNewHandsForPlayers();

	public void calculatePlayersStrength();

	public void findWinner();

	public void cleanAfterMatch();

	public int getPoints();
}
