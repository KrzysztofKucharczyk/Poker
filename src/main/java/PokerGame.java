public class PokerGame implements IPoker {

	private IFileReader fileReader;
	private WinCounter winCounter = new WinCounter();
	private IHand player, enemy;
	private int playerStrength, enemyStrength;
	int i = 0;

	public PokerGame(String filename) {
		fileReader = new PokerFileReader(filename);

	}

	public IHand getPlayer() {
		return player;
	}

	public IHand getEnemy() {
		return enemy;
	}

	@Override
	public boolean isInput() {
		return fileReader.nextLine();
	}

	@Override
	public int getPlayerStrength() {
		return playerStrength;
	}

	@Override
	public int getEnemyStrength() {
		return enemyStrength;
	}

	@Override
	public void getNewHandsForPlayers() {
		player = (PokerHand) fileReader.getNewHand();
		enemy = (PokerHand) fileReader.getNewHand();
	}

	@Override
	public void calculatePlayersStrength() {
		playerStrength = player.getFigureAnalyzer().getFigure().getFigureValue();
		enemyStrength = enemy.getFigureAnalyzer().getFigure().getFigureValue();
	}

	@Override
	public void findWinner() {
		if (playerStrength > enemyStrength)
			winCounter.addPoint();
		else if (playerStrength == enemyStrength)
			if (DrawResolver.resolve(player, enemy) == 1)
				winCounter.addPoint();
	}

	@Override
	public void cleanAfterMatch() {
		player.clear();
		enemy.clear();
	}

	@Override
	public int getPoints() {
		return winCounter.getPoints();
	}

	public void closeFile() {
		fileReader.closeInputStream();
	}

	public static void main(String[] args) {
		PokerGame poker = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\poker.txt");

		while (poker.isInput()) {
			poker.getNewHandsForPlayers();
			poker.calculatePlayersStrength();
			poker.findWinner();
			poker.cleanAfterMatch();

		}
		poker.closeFile();
		System.out.println("Points: " + poker.getPoints());
	}

}