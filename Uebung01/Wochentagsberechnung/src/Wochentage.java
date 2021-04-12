import java.util.Scanner;

public class Wochentage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int tag = 0;
		int monat = 0;
		int jahr = 0;

		System.out.println("Tag:");
		boolean reading = true;
		while (reading) {
			try {
				tag = Integer.parseInt(scanner.nextLine());
				if ((tag >= 1) && (tag <= 31)) {
					reading = false;
				} else {
					System.out.println("Eingabefehler (1-31): ");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Fehler bei der Eingabe: Geben Sie eine Zahl zwischen 1 und 31 ein.");
			}
		}
		System.out.println("Monat:");
		final int[] monatstage = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		reading = true;
		while (reading) {
			try {
				monat = Integer.parseInt(scanner.nextLine());
				if ((monat >= 1) && (monat <= 12)) {
					if ((tag <= monatstage[monat - 1])) {
						reading = false;
					} else {
						System.out.println("Der gewählte Monat hat nur " + monatstage[monat - 1] + " Tage.");
					}
				} else {
					System.out.println("Geben Sie den Monat bitte als Zahl von 1 bis 12 an.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Fehler bei der Eingabe: Geben Sie eine Zahl zwischen 1 und 12 ein.");
			}
		}
		System.out.println("Jahr (JJJJ):");
		reading = true;
		while (reading) {
			try {
				jahr = Integer.parseInt(scanner.nextLine());
				if ((jahr >= 0) && (jahr <= 9999)) {
					if (jahr < 1582) {
						System.out.println("Fehler. Der gregorianische Kalender wurde erst im Jahr 1582 eingeführt.");
					} else {
						if ((tag == 29) && (monat == 2)) { // Schaltjahr notwendig
							if (!((jahr % 4 == 0) && (!(jahr % 100 == 0) || (jahr % 400 == 0)))) {
								System.out.println(
										"Das von Ihnen gewählte Jahr ist kein Schaltjahr, daher existiert der 29.02. nicht. Wählen Sie bitte ein Schaltjahr.");
							} else {
								reading = false;
							}
						} else {
							reading = false;
						}
					}
	
				} else {
					System.out.println(
							"Fehler bei der Eingabe. Bitte geben Sie das Jahr im Format JJJJ an: z.B. 2006 oder 1888");
				}
			} catch (NumberFormatException e) {
				System.out.println("Fehler bei der Eingabe. Bitte geben Sie eine Jahreszahl ein:");
			}
				
		}
		scanner.close();

		int d = tag;
		if (monat <= 2) { // Januar oder Februar
			jahr--;
		}

		monat = (monat - 2 + 12) % 12;
		int m = monat;
//		System.out.println("m" + m);

		int y = jahr % 100;
		int c = jahr / 100;

		int a = (int) ((d + Math.floor(2.6 * m - 0.2) + y + y / 4 + c / 4 - 2 * c));

		int w = a % 7;
		if (w < 0)
			w += 7;


		switch (w) {
		case 0:
			System.out.println("Sonntag");
			break;
		case 1:
			System.out.println("Montag");
			break;
		case 2:
			System.out.println("Dienstag");
			break;
		case 3:
			System.out.println("Mittwoch");
			break;
		case 4:
			System.out.println("Donnerstag");
			break;
		case 5:
			System.out.println("Freitag");
			break;
		case 6:
			System.out.println("Samstag");
			break;
		default:
			System.out.println("Fehler: " + w);
		}
	}

}
