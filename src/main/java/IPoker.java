
public interface IPoker {

	public IHand getPlayer();

	public IHand getEnemy();

	public int getPlayerStrength();

	public int getEnemyStrength();

	public boolean isInput();

	public void getNewHandsForPlayers();

	public void calculatePlayersStrength();

	public void findWinner();

	public void cleanAfterMatch();

	public int getPoints();
}
