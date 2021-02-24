package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300 {
	static int N, K, ans;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[13];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			data[Integer.parseInt(st.nextToken()) * 6 + Integer.parseInt(st.nextToken())]++;
		}
	}
	
	private static void implement() {
		for(int i = 1; i <= 12; i++) {
			if(data[i] == 0) continue;
			ans += data[i] / K;
			if(data[i] % K != 0) {
				ans++;
			}
		}
	}
	
	private static void print() {
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}
}
