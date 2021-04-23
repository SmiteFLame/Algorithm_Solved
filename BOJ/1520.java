package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	static int N, M, answer;
	static int[][] data;
	static int[][] DP;


	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= M);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N][M];
		DP = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				DP[i][j] = -1;
			}
		}
		
		
		
		System.out.println(DFS(0, 0));
	}

	private static int DFS(int i, int j) {
		
		DP[i][j] = 0;
		
		for (int x = 0; x < 4; x++) {
			int nx = i + NEWS[x][0];
			int ny = j + NEWS[x][1];
			if (canMove(nx, ny) && data[nx][ny] < data[i][j]) {
				if(nx == N - 1 && ny == M - 1) {
					DP[i][j]++;
				}
				if(DP[nx][ny] >= 0) {
					DP[i][j] += DP[nx][ny];
				} else {
					DP[i][j] += DFS(nx, ny);
				}
				
			}
		}
		
		return DP[i][j];
	}
}
