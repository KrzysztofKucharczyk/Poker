import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Poker {

	public static void main(String[] args) throws IOException {
		String windowsPath = "C:\\Users\\KRKUCHAR\\workspace\\poker2\\src\\data\\poker.txt";
//		String linuxPath = "/home/krzysztof/workspace/poker2/poker2/src/data/test.txt";
//		String linuxRealPath = "/home/krzysztof/workspace/poker2/poker2/src/data/poker.txt";

		BufferedReader in = new BufferedReader(new FileReader(windowsPath));
		String str = new String();
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		String[] splited = new String[10];

		while ((str = in.readLine()) != null) {
			splited = str.split("\\s+");

			ArrayList<String> cards1 = new ArrayList<String>();
			ArrayList<String> cards2 = new ArrayList<String>();

			for (int i = 0; i < 5; i++)
				cards1.add(splited[i]);

			for (int i = 5; i < 10; i++)
				cards2.add(splited[i]);

			hand1.divideStringCard(cards1);
			hand2.divideStringCard(cards2);

			hand1.sort();
			hand2.sort();

			if (hand1.getStrength() > hand2.getStrength())
				hand1.addPoint();
			else if (hand1.getStrength() == hand2.getStrength())
				if (DrawResolver.resolve(hand1, hand2) == 1)
					hand1.addPoint();

			hand1.clearAll();
			hand2.clearAll();
		}
		System.out.println("Points: " + hand1.getPoints());
		in.close();
	}
}
