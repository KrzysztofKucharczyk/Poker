
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderForPoker implements FileReader {
	private Scanner scanner; 
	public FileReaderForPoker(String filename) {
		initializeFileReader(filename);

	}

	@Override
	public Hand getNewHand() {
		List<PlayingCard> cards = new ArrayList<>();
		String line;

		for (int i = 0; i < 5; i++) {
			if ((line = scanner.next()) != null) {
				int value = CardValue.convertValueString(line.substring(0, 1));
				Color color = CardColor.convertColorString(line.substring(1, 2));
				cards.add(new PlayingCard(value, color));
			}
		}
		return new PokerHand(cards);
	}

	@Override
	public boolean nextLine() {
		return scanner.hasNext();
	}
	

	private void initializeFileReader(String filename) {
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
