package Poker;
import Hand.IHand;

public interface IPoker {

	public IHand getPlayer();

	public IHand getEnemy();

	public int getPlayerStrength();

	public int getEnemyStrength();

	public boolean isInput();

	public void getNewHandsForPlayers();

	public void calculatePlayersStrength();

	public void findWinner();

	public int getPoints();
}
