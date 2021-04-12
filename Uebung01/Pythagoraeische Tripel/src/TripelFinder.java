
public class TripelFinder {

	public static void main(String[] args) {
		final int MAX = 20;
		final double e = 1e-12;
		for (int a = 1; a <= MAX; a++) {
			for (int b = 1; b <= MAX; b++) {
				for (int c = 1; c <= MAX; c++) {
					if (Math.abs(a*a + b*b - c*c) < e) {
						System.out.println("Tripel: (" + a + ", " + b + ", " + c + ")");
					}
				}
			}
		}

	}

}
