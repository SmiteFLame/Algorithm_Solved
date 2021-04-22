package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20056 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	static int N, M, K, answer;

	static class fireball {
		int W, S, D;

		public fireball(int w, int s, int d) {
			W = w;
			S = s;
			D = d;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 질량, 개수

		LinkedList<fireball>[][] map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int R = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken()) - 1;
			int W = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			map[R][C].add(new fireball(W, S, D));

		}

		for (int x = 0; x < K; x++) {
			// 1. 이동
			LinkedList<fireball>[][] newMap = new LinkedList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					newMap[i][j] = new LinkedList<>();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (fireball fb : map[i][j]) {
						int nx = i + fb.S * NEWS[fb.D][0];
						int ny = j + fb.S * NEWS[fb.D][1];
						while (nx >= N) {
							nx -= N;
						}
						while (ny >= N) {
							ny -= N;
						}
						while (nx < 0) {
							nx += N;
						}
						while (ny < 0) {
							ny += N;
						}
						newMap[nx][ny].add(new fireball(fb.W, fb.S, fb.D));
					}
				}
			}
			map = newMap;

			// 2. 합쳐짐
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].size() < 2)
						continue;
					int sumWeight = 0;
					int sumSpeed = 0;
					boolean even = true;
					boolean odd = true;
					for (fireball fb : map[i][j]) {
						sumWeight += fb.W;
						sumSpeed += fb.S;
						if (fb.D % 2 == 0) {
							odd = false;
						} else {
							even = false;
						}
					}
					int newWeight = sumWeight / 5;
					int newSpeed = sumSpeed / map[i][j].size();
					map[i][j].clear();
					if (newWeight <= 0)
						continue;
					for (int t = 0; t < 4; t++) {
						map[i][j].add(new fireball(newWeight, newSpeed, t * 2 + ((odd || even) ? 0 : 1)));
					}

				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (fireball fb : map[i][j]) {
					answer += fb.W;
				}
			}
		}

		System.out.println(answer);
	}
}
