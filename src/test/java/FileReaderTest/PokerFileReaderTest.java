package FileReaderTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CardModel.Color;
import CardModel.ICard;
import CardModel.PlayingCard;
import FileManagement.IFileReader;
import FileManagement.PokerFileReader;
import Hand.IHand;
import Hand.PokerHand;

public class PokerFileReaderTest {

	private IHand testHand;
	private IFileReader fileReader;
	
	@Before
	public void before() {
		String testFilePath = "src/data/test.txt";
		if(System.getProperty("os.name").equals("Windows"))
			testFilePath.replace("/", "\\");
			
		fileReader = new PokerFileReader(testFilePath);
	}
	
	@Test
	public void getNewhand() {
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
		for (int i = 0; i < 3; i++) {
			testHand = fileReader.getNewHand();
			assertTrue(fileReader.nextLine());
		}
		testHand = fileReader.getNewHand();
		assertFalse(fileReader.nextLine());

	}

}
