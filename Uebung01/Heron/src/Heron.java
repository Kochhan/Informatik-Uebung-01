import java.util.Scanner;

public class Heron {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Zahl, bitte:");
		double x = 0;
		boolean reading = true;
		while (reading) {
			String line = scanner.nextLine();
			try {
				x = Double.parseDouble(line);
				reading = false;
			} catch (NumberFormatException e) {
				System.out.println("Fehler. Bitte geben Sie eine Zahl zwischen " + Double.MIN_VALUE + " und " + Double.MAX_VALUE + " ein. Nutzen Sie als Dezimalzeichen einen Punkt.");
			} 
		}
		scanner.close();
		
		double a = x;
		double b = 1;
		while (Math.abs(a-b) > 1e-14) {
			a = (a + b) / 2.0;
			b = x / a;
		}
		
		System.out.println("Die Quadratwurzel von " + x + " ist " + a + ".");
	}

}
