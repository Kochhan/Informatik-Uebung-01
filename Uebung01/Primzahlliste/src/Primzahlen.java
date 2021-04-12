import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primzahlen {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wie viele Primzahlen hätten wir denn gerne?");
		int anzahl = 0;
		boolean reading = true;
		while (reading) {
			try {
				anzahl = Integer.parseInt(scanner.nextLine());
				if (anzahl < 1) {
					System.out.println("Fehler. Geben Sie eine Anzahl ein.");
				} else {
					reading = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Geben Sie eine Zahl zwischen " + 1 + " und " + Integer.MAX_VALUE + " ein.");
			}
		}
		
		scanner.close();
		
		List<Integer> primzahlen = new ArrayList<Integer>();
		int zahl = 2;
		while (primzahlen.size() < anzahl) {
			if (isPrime(zahl)) {
				primzahlen.add(zahl);
			}
			zahl++;
		}
		
		System.out.println(primzahlen.toString());
	}

	private static boolean isPrime(int x) {
		int quadratwurzel = (int) Math.sqrt(x);
		for (int i = 2; i <= quadratwurzel; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

}
