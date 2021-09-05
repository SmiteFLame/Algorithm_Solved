import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int answer = 1;
		while (B != A) {
			answer++;
			if (B < A) {
				System.out.println(-1);
				return;
			}

			String str = String.valueOf(B);

			if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
				System.out.println(-1);
				return;
			}

			if (B % 2 == 0) {
				B >>= 1;
			} else {
				str = str.substring(0, str.length() - 1);
				B = Long.parseLong(str);
			}

		}
		System.out.println(answer);
	}
}
