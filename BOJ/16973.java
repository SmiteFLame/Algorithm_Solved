package ssafy.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	static int N, M, H, W, Sr, Sc, Fr, Fc, answer;
	static int[][] map;
	static Queue<int[]> queue = new LinkedList<>();

	private static boolean canMove(int X, int Y) {
		if (X < 0 | Y < 0 || X + H - 1 >= N || Y + W - 1 >= M || map[X][Y] == -1) {
			return false;
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[X + i][Y + j] == 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken()) - 1;
		Sc = Integer.parseInt(st.nextToken()) - 1;
		Fr = Integer.parseInt(st.nextToken()) - 1;
		Fc = Integer.parseInt(st.nextToken()) - 1;

		answer = Integer.MAX_VALUE;

		queue.add(new int[] { Sr, Sc, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (now[0] == Fr && now[1] == Fc) {
				answer = now[2];
				break;
			}

			for (int x = 0; x < 4; x++) {
				int nx = now[0] + NEWS[x][0];
				int ny = now[1] + NEWS[x][1];

				if (!canMove(nx, ny))
					continue;

				map[nx][ny] = -1;

				queue.add(new int[] { nx, ny, now[2] + 1 });

			}

		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}
