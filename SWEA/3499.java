package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_¾çµ¿Çõ {
	static int T, N;
	static Queue<String> front = new LinkedList<>();
	static Queue<String> back = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void init() throws NumberFormatException, IOException {
		front.clear();
		back.clear();
		N = Integer.parseInt(io.readLine());
		st = new StringTokenizer(io.readLine());
		for(int i = 1; i <= N; i++) {
			if(i <= (N + 1) / 2) front.offer(st.nextToken());
			else back.offer(st.nextToken());
		}		
	}
		

	public static void implement() {
		while(!front.isEmpty()) {
			sb.append(front.poll() + " ");
			if(!back.isEmpty()) {
				sb.append(back.poll() + " ");
			}
		}
		sb.append("\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(io.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			init();
			implement();
		}

		System.out.println(sb.toString());
	}
}