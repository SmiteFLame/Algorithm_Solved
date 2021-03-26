package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17069_양동혁 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static long[][][] DP;
	static boolean[][] map;
	
	private static boolean canMove(int X, int Y) {
		if (X >= N || Y >= N || map[X][Y]) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
//		init
		N = Integer.parseInt(in.readLine());

		map = new boolean[N][N];
		// X, Y, loc
		DP = new long[N][N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
		
		DP[0][1][0] = 1;

		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				// 가로
				if(canMove(i, j + 1)) {
					DP[i][j + 1][0] += (DP[i][j][0] + DP[i][j][2]);
				}
				// 세로
				if(canMove(i + 1, j)) {
					DP[i + 1][j][1] += (DP[i][j][1] + DP[i][j][2]);
				}
				// 대각선
				if(canMove(i, j + 1) && canMove(i + 1, j) && canMove(i + 1, j + 1)) {
					DP[i + 1][j + 1][2] += (DP[i][j][0] + DP[i][j][1] + DP[i][j][2]);
				}
			}
		}

		System.out.println(DP[N - 1][N - 1][0] + DP[N - 1][N - 1][1] + DP[N - 1][N - 1][2]);
	}
}