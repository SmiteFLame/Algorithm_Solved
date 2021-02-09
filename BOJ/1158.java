package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S5_1158_¾çµ¿Çõ {
	static int N, K;
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> answer = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
	}
	
	private static void implement(){
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0; i < K - 1; i++) queue.offer(queue.poll());
			sb.append(queue.poll()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		implement();
		System.out.println(sb.toString());
	}
}
