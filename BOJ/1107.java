package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, ans;
	static boolean[] notwork;

	private static boolean isBreak(String S) {
		for (int i = 0, end = S.length(); i < end; i++) {
			if (notwork[S.charAt(i) - '0'])
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		notwork = new boolean[10];

		if (M != 0) {
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				notwork[Integer.parseInt(st.nextToken())] = true;
			}
		}

		ans = Math.abs(N - 100);

		for (int i = 0; i <= 1000000; i++) {
			String S = String.valueOf(i);
			if (isBreak(S))
				continue;
			ans = S.length() + Math.abs(i - N) < ans ? S.length() + Math.abs(i - N) : ans;
		}

		System.out.println(ans);
	}

}
