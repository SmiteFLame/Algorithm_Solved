package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_양동혁 {
	static int T, N, M, max = 0;
	static int[][] map;
	static int[][] DP;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			max = 0;
			map = new int[N][N];
			DP = new int[N + 1][N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					// 각각의 값들을 전무 N,N까지 더하기 
					for (int k = i; k < N; k++) {
						for (int l = j; l < N; l++) {
							DP[k + 1][l + 1] += map[i][j];
						}
					}
				}
			}

			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					
					// 전체에서 위, 왼쪽을 뺀 후 공통으로 뺀 값을 다시 더하기
					int sum = DP[i][j] - DP[i - M][j] - DP[i][j - M] + DP[i - M][j - M];
					
					System.out.println(sum);
					max = Math.max(max, sum);
				}
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}
}
