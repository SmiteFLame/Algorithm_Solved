package ssafy.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1034 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K, answer;
	static String[] data;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		data = new String[N];
		
		for (int i = 0; i < N; i++) {
			data[i] = in.readLine();			
		}

		K = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < M; j++) {
				if(data[i].charAt(j) == '0') cnt++; 
			}
			
			if(cnt <= K && cnt % 2 == K % 2) {
				int count = 0;
				for(int j = 0; j < N; j++) {
					if(data[i].equals(data[j])) {
						count++;
					}
				}
				answer = count > answer ? count : answer;
			}
		}

		System.out.println(answer);
	}
}
