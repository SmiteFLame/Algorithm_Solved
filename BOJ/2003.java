package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {
	static int N, M, ans;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static void init() throws IOException{
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		data = new int[N];
		
		st = new StringTokenizer(io.readLine());
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void implement() {
		int L = 0, R = 0, sum = 0;
		while(true) {
			if(sum < M) {
				if(R == N) return;		
				sum += data[R++];
			} else {
				sum -= data[L++];
			}
			if(sum == M) ans++;	
		}
	}
	
	private static void print() {
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();
	}

}
