import java.util.Scanner;

public class Quersumme {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben Sie eine Zahl ein:");
		long n = 0;
		boolean reading = true;
		while (reading) {
			String line = scanner.nextLine();
			try {
				n = Long.parseLong(line);
				reading = false;
			} catch (NumberFormatException e) {
				System.out.println("Fehler Bitte geben Sie eine Ganzzahl zwischen " + Long.MIN_VALUE + " und " + Long.MAX_VALUE + " ein.");
			} 
		}
		scanner.close();
		int quersumme = 0;
		long x = n;
		do {
			quersumme += x % 10;
			x /= 10;
		} while (x > 0);
		
		System.out.println("Die Quersumme der Zahl " + n + " ist " + quersumme + "." );
		

	}

}
