package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, cnt;
	static int[][] wall;

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		wall = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static boolean canMove(int X, int Y) {
		if (X < 0 || Y < 0 || X >= N || Y >= N || wall[X][Y] == 1) {
			return false;
		}
		return true;
	}

	// 0 가로, 1 세로, 2 대각선
	private static void DFS(int X, int Y, int state) {
		if (X == N - 1 && Y == N - 1) {
			cnt++;
			return;
		}

		// 가로
		if (canMove(X, Y + 1) && state != 1) {
			DFS(X, Y + 1, 0);
		}

		// 세로
		if (canMove(X + 1, Y) && state != 0) {
			DFS(X + 1, Y, 1);
		}

		// 대각선
		if (canMove(X, Y + 1) && canMove(X + 1, Y + 1) && canMove(X + 1, Y)) {
			DFS(X + 1, Y + 1, 2);
		}

	}

	private static void implement() {
		DFS(0, 1, 0);
	}

	private static void print() {
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}