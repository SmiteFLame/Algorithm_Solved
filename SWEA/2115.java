package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2115_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, C, answer;
	static int[][] honey;
	static int[][] max;
	static int[] honeyList;

	private static void subset(int i, int j, int idx, int sum, int sumDouble) {
		
		if(sum > C) {
			return;
		}
		
		if(idx == M) {
			max[i][j] = sumDouble > max[i][j] ? sumDouble : max[i][j];
			return;
		}
		
		subset(i, j, idx + 1, sum, sumDouble);
		subset(i, j, idx + 1, sum + honeyList[idx], sumDouble + (honeyList[idx] * honeyList[idx]));		
	}
	
	
	public static void main(String[] args) throws IOException{
		for(int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			honey = new int[N][N];
			max = new int[N][N - M + 1];
			honeyList = new int[N];
			answer = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					for(int k = 0; k < M; k++) {
						honeyList[k] = honey[i][j + k];
					}
					subset(i, j, 0, 0, 0);
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					for(int k = 0; k < N; k++) {
						for(int l = 0; l < N - M + 1; l++) {
							if(i == k && Math.abs(j - l) < M) continue;
							answer = max[i][j] + max[k][l] > answer ? max[i][j] + max[k][l] : answer;
						}
					}
				}
			}
			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}
