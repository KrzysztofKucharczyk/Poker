package FileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CardModel.Suite;
import CardModel.ICard;
import CardModel.PlayingCard;
import Hand.IHand;
import Hand.PokerHand;

public class PokerFileReader implements IFileReader {
	private Scanner scanner;
	
	public PokerFileReader(String filename) {
		initializeFileReader(filename);
	}

	@Override
	public IHand getNewHand() {
		List<ICard> cards = new ArrayList<>();
		String line;

		for (int i = 0; i < 5; i++) {
			if ((line = scanner.next()) != null) {
				int value = convertValueString(line.substring(0, 1));
				Suite suite = convertSuiteString(line.substring(1, 2));
				cards.add(new PlayingCard(value, suite));
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
	
	private int convertValueString(String value) {
		if (value.equals("T"))
			return 10;
		else if (value.equals("J"))
			return 11;
		else if (value.equals("Q"))
			return 12;
		else if (value.equals("K"))
			return 13;
		else if (value.equals("A"))
			return 14;
		else
			return new Integer(value);

	}
	
	private Suite convertSuiteString(String suite) {
		if (suite.equals("D"))
			return Suite.D;
		else if (suite.equals("S"))
			return Suite.S;
		else if (suite.equals("H"))
			return Suite.H;
		else
			return Suite.C;
	}
	
	@Override
	public void closeInputStream() {
		scanner.close();
	}
}
