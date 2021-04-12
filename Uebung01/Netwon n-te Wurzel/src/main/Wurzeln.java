package main;

import java.util.Scanner;

public class Wurzeln {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ordnung der Wurzel:");
		boolean reading = true;
		int n = 0;
		while (reading) {
			try {
				n = Integer.parseInt(scanner.nextLine());
				if ((n > 1) && (n < 100)) {
					reading = false;
				} else {
					System.out.println("Fehler. Bitte geben Sie eine Zahl zwischen 2 und 100 ein.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Fehler. Bitte geben Sie eine Ganzzahl ein.");
			}
		}
		
		System.out.println("Was wurzeln?:");
		double q = 0;
		reading = true;
		while (reading) {
			try {
				q = Double.parseDouble(scanner.nextLine());
				reading = false;
			} catch (NumberFormatException e) {
				System.out.println("Fehler. Bitte geben Sie eine Zahl zwischen " + Double.MIN_VALUE + " und " + Double.MAX_VALUE + " ein. Nutzen Sie als Dezimalzeichen einen Punkt.");
			}
		}
			
		scanner.close();
		
		double xPrev;
		double x = q;
		int k = 0;
		do {
			xPrev = x;
			x = xPrev - (Math.pow(xPrev, n) - q) / (n * Math.pow(xPrev, n-1));
			k++;
		} while ((k < 1000) && (Math.abs(xPrev - x) > 1e-20));

		System.out.println("Fertig nach " + k + " Iterationsschritten.");
		System.out.println("Die " + n + "te Wurzel aus " + q + " ist " + x);
		System.out.println("Die Antwort aus der Standartbibliothek: " + Math.pow(q, 1.0/n));
	}

}
