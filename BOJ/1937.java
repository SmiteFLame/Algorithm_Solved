package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1937 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N, answer;
	static int[][] count;
	static int[][] map;

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}

	private static int DFS(int X, int Y, int cnt) {
		if(count[X][Y] != -1) return count[X][Y]; 
		count[X][Y] = 1;
		for (int x = 0; x < 4; x++) {
			int nx = X + NEWS[x][0];
			int ny = Y + NEWS[x][1];
			if (!canMove(nx, ny))
				continue;

			if (map[nx][ny] > map[X][Y]) {
				count[X][Y] = Math.max(DFS(nx, ny, cnt + 1) + 1, count[X][Y]);
			}
		}
		return count[X][Y];
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		count = new int[N][N];
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(count[i], -1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(DFS(i, j, 1), answer);
			}
		}
		System.out.println(answer);
	}

}
