package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_¾çµ¿Çõ {
	static int T, N, ans, end;
	static int[] data;
	static int[] order;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	private static void init() throws IOException{
		N = Integer.parseInt(io.readLine());
		data = new int[N];
		
		st = new StringTokenizer(io.readLine());
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		order = new int[N];
		
		ans = 0;
	}
	
	private static void subset(int cnt, int lSum, int rSum) {
		if(lSum < rSum) return;
		if(cnt == N) {
			ans++;
			return;
		}
		subset(cnt + 1, lSum + data[order[cnt]], rSum);
		subset(cnt + 1, lSum, rSum + data[order[cnt]]);
	}
	
	private static void implement(int cnt, int idx, int flag) {
		if(cnt == N) {
			subset(0, 0, 0);
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			order[cnt] = i;
			implement(cnt + 1, i + 1, flag | 1 << i);
		}
	}
	
	private static void print(int tc) {
		sb.append("#" + tc + " " + ans + "\n");
	}

	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(io.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			init();
			implement(0, 0, 0);
			print(test_case);			
		}
		System.out.println(sb.toString());
	}
}
