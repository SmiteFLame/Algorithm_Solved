import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1783 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int result = 0;

		if (N == 1) {
			result = 1;
		} else if (N == 2) {
			result = Math.min((M + 1) / 2, 4);
		} else if (N >= 3) {
			if (M < 7) {
				result = Math.min(M, 4);
			} else {
				result = M - 2;
			}
		}

		System.out.println(result);
	}

}
