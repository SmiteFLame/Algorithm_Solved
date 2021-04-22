package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17406 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K, answer;

	static ArrayList<int[]> rotation = new ArrayList<>();

	private static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	private static void per(int[][] map, int cnt, int flag) {
		if (cnt == K) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < M; j++) {
					sum += map[i][j];
				}
				min = min < sum ? min : sum;
			}
			answer = min < answer ? min : answer;
			return;
		}

		for (int x = 0; x < K; x++) {
			if ((flag & (1 << x)) != 0)
				continue;
			int[][] newMap = copyMap(map);

			int[] now = rotation.get(x);

			for (int i = 1; i <= now[2]; i++) {
				int temp = newMap[now[0] - i][now[1] - i];

				for (int j = 0; j < i * 2; j++) {
					newMap[now[0] - i + j][now[1] - i] = newMap[now[0] - i + j + 1][now[1] - i];
				}
				for (int j = 0; j < i * 2; j++) {
					newMap[now[0] + i][now[1] - i + j] = newMap[now[0] + i][now[1] - i + j + 1];
				}
				for (int j = 0; j < i * 2; j++) {
					newMap[now[0] + i - j][now[1] + i] = newMap[now[0] + i - j - 1][now[1] + i];
				}
				for (int j = 0; j < i * 2; j++) {
					newMap[now[0] - i][now[1] + i - j] = newMap[now[0] - i][now[1] + i - j - 1];
				}

				newMap[now[0] - i][now[1] - i + 1] = temp;
			}

			per(newMap, cnt + 1, flag | 1 << x);
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			rotation.add(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) });
		}

		answer = Integer.MAX_VALUE;
		
		per(copyMap(map), 0, 0);
		System.out.println(answer);

	}
}
