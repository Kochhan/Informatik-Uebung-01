import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		BigInteger[] fibonacci = new BigInteger[100];
		fibonacci[0] = new BigInteger("1");
		fibonacci[1] = new BigInteger("1");
		for (int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
		}
		
		System.out.println(Arrays.toString(fibonacci));
	}
}
