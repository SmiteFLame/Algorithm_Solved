package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_¾çµ¿Çõ {
	static int T, N, L, max = 0;
	static int[] score, cal;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		score = new int[N];
		cal = new int[N];
		max = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			score[i] = Integer.parseInt(st.nextToken());
			cal[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void subset(int idx, int sumScore, int sumCal) {
		if(idx == N) {
			max = sumScore > max ? sumScore : max;
			return;
		}
		subset(idx + 1, sumScore, sumCal);
		if(sumCal + cal[idx] <= L) {
			subset(idx + 1, sumScore + score[idx], sumCal+ cal[idx]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(io.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			init();
			subset(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
