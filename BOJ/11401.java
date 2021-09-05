import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final long P = 1000000007;

	private static long factorial(long N) {
		long fac = 1L;

		while (N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
	}

	private static long pow(long base, long expo) {
		if (expo == 1) {
			return base % P;
		}

		long temp = pow(base, expo / 2);

		if (expo % 2 == 1) {
			return (temp * temp % P) * base % P;
		}
		return temp * temp % P;

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		long numer = factorial(N);

		long denom = factorial(K) * factorial(N - K) % P;

		System.out.println(numer * pow(denom, P - 2) % P);

	}
}
