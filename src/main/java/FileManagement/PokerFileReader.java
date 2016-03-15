package FileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
				int value = convertValueString(line.substring(0, 1));
				Color color = convertColorString(line.substring(1, 2));
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
	
	public int convertValueString(String value) {
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
	
	public Color convertColorString(String color) {
		if (color.equals("D"))
			return Color.D;
		else if (color.equals("S"))
			return Color.S;
		else if (color.equals("H"))
			return Color.H;
		else
			return Color.C;
	}
	
	@Override
	public void closeInputStream() {
		scanner.close();
	}
}
