package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[][] map;
	static long[][] DP;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		DP = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DP[0][0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == N - 1 && j == N - 1) continue;
				int next = map[i][j];
				if(i + next < N) {
					DP[i + next][j] += DP[i][j];
				}
				if(j + next < N) {
					DP[i][j + next] += DP[i][j];
				}
			}
		}
		System.out.println(DP[N - 1][N - 1]);

	}
}
