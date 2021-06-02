package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1389 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int INF = 123456789;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()) - 1;
			map[n][m] = 1;
			map[m][n] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			map[i][i] = 0;
		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int answer = -1;
		int sum = INF;
		for(int i = 0; i < N; i++) {
			int rsum = 0;
			for(int j = 0 ; j < N; j++) {
				rsum += map[i][j];
			}
			if(sum > rsum) {
				answer = i + 1;
				sum = rsum;
			}
		}
		
		System.out.println(answer);
	}

}
