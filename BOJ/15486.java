package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int[] DP = new int[N + 1];
		int answer = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());	
			
			// 진행되는 일정 및 금액
			int during = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			// 이 전의 값들까지 중에서 최고의 값들로 계속 생신하기
			answer = DP[i] > answer ? DP[i] : answer;
			
			// 해당하는 날짜에 데이터를 넣을 수 있는 경우에만 데이터를 추가하기
			if(i + during > N) continue;
			DP[i + during] = DP[i + during] > answer + price ? DP[i + during] : answer + price;
		}
		
		// 마지막에 데이터 추가된 경우를 확인하기 위해서 가장 최대값을 따로 뽑기
		System.out.println(answer > DP[N] ? answer : DP[N]);
	}
}
