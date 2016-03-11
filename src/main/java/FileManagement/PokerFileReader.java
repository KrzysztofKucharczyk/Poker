package FileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CardModel.CardColor;
import CardModel.CardValue;
import CardModel.Color;
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
	
	@Override
	public void closeInputStream() {
		scanner.close();
	}
}
