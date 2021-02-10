package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_¾çµ¿Çõ {
	static int N;
	static boolean flag;
	static char token;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		flag = true;
	}
	
	private static void implement() throws IOException {
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(io.readLine());
			if(!flag) continue
			st.nextToken();
			token = st.nextToken().charAt(0);
			if(token >= '0' && token <= '9') {
				if(st.countTokens() != 0) {
					flag = false;
				}
			} else {
				if(st.countTokens() != 2) {
					flag = false;
				}
			}
		}
	}
	
	private static void print(int test_case) {
		sb.append("#").append(test_case).append(" ").append(flag ? 1 : 0).append("\n");
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
