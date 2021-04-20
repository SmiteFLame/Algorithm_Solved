package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][][] spread = {
			{ { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, 0, 0, 0, 0 }, { 0, 10, 7, 1, 0 }, { 0, 0, 2, 0, 0 } },
			{ { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 2, 7, 0, 7, 2 }, { 0, 10, 0, 10, 0 }, { 0, 0, 5, 0, 0 } }, 
			{ { 0, 0, 2, 0, 0 }, { 0, 1, 7, 10, 0 }, { 0, 0, 0, 0, 5 }, { 0, 1, 7, 10, 0 }, { 0, 0, 2, 0, 0 } },
			{ { 0, 0, 5, 0, 0 }, { 0, 10, 0, 10, 0 }, { 2, 7, 0, 7, 2 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 } }};

	static final int[][] NEWS = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	static int N, startX, startY, dir, answer;
	static int[][] map;
	static boolean[][] visited;

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		startX = N / 2;
		startY = N / 2;
		dir = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 0, end = i == N ? 1 : 2; j < end; j++) {
				for (int x = 0; x < i; x++) {
					if (startX == 0 && startY == 0)
						break;

					startX += NEWS[dir][0];
					startY += NEWS[dir][1];
					int nowDust = map[startX][startY];

					for (int k = -2; k <= 2; k++) {
						for (int l = -2; l <= 2; l++) {
							int nx = startX + k;
							int ny = startY + l;
							int nextDust = (map[startX][startY] * spread[dir][k + 2][l + 2]) / 100;
							nowDust -= nextDust;
							if (canMove(nx, ny)) {
								map[nx][ny] += nextDust;
							} else {
								answer += nextDust;
							}
						}
					}

					if (canMove(startX + NEWS[dir][0], startY + NEWS[dir][1])) {
						map[startX + NEWS[dir][0]][ startY + NEWS[dir][1]] += nowDust;
					} else {
						answer += nowDust;
					}
					
					map[startX][startY] = 0;

				}
				dir = dir == 3 ? 0 : dir + 1;
			}
		}
		
		System.out.println(answer);

	}

}
