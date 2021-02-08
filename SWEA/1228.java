package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_¾çµ¿Çõ {
	static int N, M, S, K;
	static LinkedList<Integer> list = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
		
		
	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		
		list.clear();
		
		st = new StringTokenizer(io.readLine());
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}		

		M = Integer.parseInt(io.readLine());
		st = new StringTokenizer(io.readLine());
	}
	
	private static void implement() {
		for(int i = 0; i < M; i++) {
			st.nextToken();
			S = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for(int j = S; j < S + K; j++) {
				list.add(j, Integer.parseInt(st.nextToken()));		
			}
			print(i);
		}
	}
	
	private static void print(int test_case) {
		sb.append("#").append(test_case).append(" ");
		for(int i = 0; i < 10; i++) {
			sb.append(list.get(i)).append(" ");
		}
		sb.append("\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int test_case = 1; test_case <= 10; test_case++) {
			init();
			implement();
			print(test_case);
		}
		System.out.println(sb.toString());
	}
}
