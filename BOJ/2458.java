package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2458 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N + 1][N + 1];
		boolean[][] mapR = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			map[small][tall] = true;
			mapR[tall][small] = true;
		}

		// 플로어드 워샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][k] && map[k][j]) {
						map[i][j] = true;
					}

					if (mapR[i][k] && mapR[k][j]) {
						mapR[i][j] = true;
					}
				}
			}
		}

		answer = 0;

		next: for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				if (!map[i][j] && !mapR[i][j])
					continue next;
			}
			answer++;
		}
		System.out.println(answer);
	}
}
