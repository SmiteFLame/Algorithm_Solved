import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1735 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		int A1 = Integer.parseInt(st.nextToken()), A2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int B1 = Integer.parseInt(st.nextToken()), B2 = Integer.parseInt(st.nextToken());
		int child = A1 * B2 + A2 * B1;
		int parent = A2 * B2;
		int gcd = GCD(Math.max(child, parent), Math.min(child, parent));
		System.out.println(child / gcd + " " + parent/ gcd);
	}

}
