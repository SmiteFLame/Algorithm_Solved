package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int D, W, K, answer;
	static int[][] film, copy;

	private static boolean check(int[][] film) {
		next: for (int j = 0; j < W; j++) {
			int cnt = 1;
			int now = film[0][j];
			for (int i = 1; i < D; i++) {
				if (now == film[i][j]) {
					cnt++;
					if (cnt == K)
						continue next;
				} else {
					cnt = 1;
					now = film[i][j];
				}
			}

			return false;
		}
		return true;
	}

	private static void subset(int idx, int cnt) {

		if (cnt >= answer) {
			return;
		}

		if (idx == D) {
			if (check(copy)) {
				answer = cnt < answer ? cnt : answer;
			}
			return;
		}
		
		subset(idx + 1, cnt);

		Arrays.fill(copy[idx], 0);
		subset(idx + 1, cnt + 1);

		Arrays.fill(copy[idx], 1);
		subset(idx + 1, cnt + 1);

		copy[idx] = film[idx].clone();
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			copy = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
				copy[i] = film[i].clone();
			}

			answer = D;
			if (K == 1)
				answer = 0;
			else
				subset(0, 0);

			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}