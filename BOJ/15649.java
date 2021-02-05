package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15649_¾çµ¿Çõ {
	static int N, M;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[M];
	}
	
	public static void makePermu(int cnt, int flag) {
		if(cnt == M) {
			for(int i : data) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			data[cnt] = i + 1;
			makePermu(cnt + 1, flag | 1 << i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		makePermu(0, 0);
		System.out.println(sb.toString());
	}
}
