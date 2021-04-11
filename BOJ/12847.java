package ssafy.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12847 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		long[] money = new long[N + 1];
		
		for(int i = 1; i <= M; i++) {
			money[i] = money[i - 1] + Integer.parseInt(st.nextToken());
		}

		long answer = money[M];
		
		for(int i = M + 1; i <= N; i++) {
			money[i] = money[i - 1] + Integer.parseInt(st.nextToken());
			answer = money[i] - money[i - M] > answer ? money[i] - money[i - M] : answer;
		}
		
		System.out.println(answer);
	}
}
