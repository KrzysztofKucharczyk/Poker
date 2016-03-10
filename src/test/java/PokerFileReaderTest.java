import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PokerFileReaderTest {

	private IHand testHand;
	
	@Test
	public void getNewhand() {
		IFileReader fileReader = new PokerFileReader("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		testHand = fileReader.getNewHand();

		List<ICard> cardList = new ArrayList<>();

		for (int i = 1; i <= 5; i++)
			cardList.add(new PlayingCard(i, Color.D));

		IHand checkingHand = new PokerHand(cardList);
		assertNotNull(fileReader);
		assertTrue(testHand.toString().equals(checkingHand.toString()));
	}

	@Test
	public void getInformationIfThereIsANewLine() {
		IFileReader fileReader = new PokerFileReader("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\test.txt");
		

		for (int i = 0; i < 3; i++) {
			testHand = fileReader.getNewHand();
			assertTrue(fileReader.nextLine());
		}
		testHand = fileReader.getNewHand();
		assertFalse(fileReader.nextLine());

	}

}
