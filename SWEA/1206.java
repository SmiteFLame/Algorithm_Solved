package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1206_¾çµ¿Çõ {
	static int N, ans;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	
	private static void init() throws IOException{
		N = Integer.parseInt(io.readLine());
		data = new int[N];		
		
		ans = 0;
		
		st = new StringTokenizer(io.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void implement() {
		for(int i = 2; i < N - 2; i++) {
			int X = Math.max(Math.max(data[i - 2], data[i - 1]), Math.max(data[i + 1], data[i + 2]));
			ans += data[i] > X ? data[i] - X : 0;
		}
	}
	
	private static void print(int tc) throws IOException {
		ot.write("#" + tc + " " + ans + "\n");
	}
	
	public static void main(String[] args) throws IOException{
		for(int tc = 1; tc <= 10; tc++) {
			init();
			implement();
			print(tc);
		}
		ot.flush();
		ot.close();
	}

}
