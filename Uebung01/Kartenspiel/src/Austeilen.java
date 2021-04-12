import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Austeilen {

	public static void main(String[] args) {

		Random random = new Random();

		boolean[] karten = new boolean[32];
		int karten_verbleibend = karten.length;

		for (int spieler = 1; spieler <= 4; spieler++) {
			System.out.println("Spieler Nr. " + spieler);
			List<Integer> hand = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {
				int r = random.nextInt(karten_verbleibend);
				int x = 0;
				for (int j = 0; j < karten.length; j++) {
					if (!karten[j]) {
						if (x == r) {
							if (karten[j]) {
								System.out.println(hand.toString());
								System.out.println("Fehler! Fehler!");
							}
							hand.add(j);
							karten[j] = true;
							karten_verbleibend--;
							j = Integer.MAX_VALUE-1; // for-loop beenden
						} else {
							x++;
						}
					}
				}
			}
			
			
			System.out.println("Karten: " + handToString(hand));
			
			if (hand.size() != 5) {
				System.out.println("Fehler");
			}
		}
		
		System.out.println(Arrays.toString(karten));
	}
	
	private static String handToString(List<Integer> hand) {
		StringBuilder sHand = new StringBuilder();
		sHand.append("[");
		for (int x = 0; x < hand.size(); x++) {
			int karte = hand.get(x);
			switch(karte / 8) {
			case 0:
				sHand.append('♥');
				break;
			case 1:
				sHand.append('♦');
				break;
			case 2:
				sHand.append('♣');
				break;
			case 3:
				sHand.append('♠');
			}
			
			sHand.append('-');
			
			switch(karte % 8) {
			case 0:
				sHand.append("Sieben");
				break;
			case 1:
				sHand.append("Acht");
				break;
			case 2:
				sHand.append("Neun");
				break;
			case 3:
				sHand.append("Zehn");
				break;
			case 4:
				sHand.append("Bube");
				break;
			case 5:
				sHand.append("Dame");
				break;
			case 6:
				sHand.append("König");
				break;
			case 7:
				sHand.append("Ass");
				break;
			}
			
			if (x < hand.size()-1) {
				sHand.append(", ");
			}
			else {
				sHand.append("]");
			}
		}
		return sHand.toString();
	}

}
