package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2343 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, temp;
	static int[] DP;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int left = 0, right = 0;
		
		DP = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			DP[i] = Integer.parseInt(st.nextToken());
			right += DP[i];
			left = DP[i] > left ? DP[i] : left;
		}
		
		// 이분 탐색 시작
		int answer = right;
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += DP[i];
				if(sum > mid) {
					sum = DP[i];
					cnt++;
				}
			}
			
			if(sum > 0) cnt++;
			
			if(cnt <= M) {
				answer = answer < mid ? answer : mid;
				right = mid - 1;
			}
			else left = mid + 1;
		}
		
		System.out.println(answer);
	}
}
