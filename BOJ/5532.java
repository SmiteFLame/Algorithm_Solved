import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5532 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		M = (int) Math.ceil((double) M / m);
		K = (int) Math.ceil((double) K / k);
		System.out.println(N - Math.max(M, K));
	}
}
