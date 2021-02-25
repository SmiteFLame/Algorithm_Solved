package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1244_¾çµ¿Çõ {
	static int T, N, K, ans;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new int[N];
		st = new StringTokenizer(io.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
	}

	private static void implement(int idx, int sum) {
		if(sum > K) return;
		if (idx == N) {
			if(sum == K) ans++;
			return;
		}
		implement(idx + 1, sum + data[idx]);
		implement(idx + 1, sum);
	}

	private static void print(int tc) throws IOException {
		ot.write("#" + tc + " " + ans + "\n");
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(io.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			implement(0, 0);
			print(tc);
		}
		ot.flush();
		ot.close();
	}

}
