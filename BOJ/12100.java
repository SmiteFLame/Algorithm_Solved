package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, answer;

	private static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	private static void DFS(int[][] map, int loc, int cnt) {

		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer = map[i][j] > answer ? map[i][j] : answer;
				}
			}
			return;
		}

		if (loc == 0) {
			// 이동
			for (int j = 0; j < N; j++) {
				for (int k = N - 1; k >= 0; k--) {
					for (int i = k - 1; i >= 0; i--) {
						if (map[k][j] == map[i][j]) {
							map[i][j] *= 2;
							map[k][j] = 0;
							k = i;
							break;
						} else if (map[i][j] != 0) {
							break;
						}
					}
				}
			}

			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] != 0)
						continue;
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] == 0)
							continue;
						map[i][j] = map[k][j];
						map[k][j] = 0;
						break;
					}
				}
			}

		} else if (loc == 1) {
			// 이동

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int i = k + 1; i < N; i++) {
						if (map[k][j] == map[i][j]) {
							map[i][j] *= 2;
							map[k][j] = 0;
							k = i;
							break;
						} else if (map[i][j] != 0) {
							break;
						}
					}
				}
			}
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] != 0)
						continue;
					for (int k = i + 1; k < N; k++) {
						if (map[k][j] == 0)
							continue;
						map[i][j] = map[k][j];
						map[k][j] = 0;
						break;
					}
				}
			}

		} else if (loc == 2) {
			// 왼쪽
			for (int i = 0; i < N; i++) {
				for (int k = N - 1; k >= 0; k--) {
					for (int j = k - 1; j >= 0; j--) {
						if (map[i][k] == map[i][j]) {
							map[i][j] *= 2;
							map[i][k] = 0;
							k = j;
							break;
						} else if (map[i][j] != 0) {
							break;
						}
					}
				}
			}

			// 0 보간
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0)
						continue;
					for (int k = j - 1; k >= 0; k--) {
						if (map[i][k] == 0)
							continue;
						map[i][j] = map[i][k];
						map[i][k] = 0;
						break;
					}
				}
			}
		} else if (loc == 3) {
			// 아래쪽

			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					for (int j = k + 1; j < N; j++) {
						if (map[i][k] == map[i][j]) {
							map[i][j] *= 2;
							map[i][k] = 0;
							k = j;
							break;
						} else if (map[i][j] != 0) {
							break;
						}
					}
				}
			}

			// 0 보간
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0)
						continue;
					for (int k = j + 1; k < N; k++) {
						if (map[i][k] == 0)
							continue;
						map[i][j] = map[i][k];
						map[i][k] = 0;
						break;
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			DFS(copyMap(map), i, cnt + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 4; i++) {
			DFS(copyMap(map), i, 0);
		}
		System.out.println(answer);

	}

}
