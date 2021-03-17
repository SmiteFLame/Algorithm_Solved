package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, cnt = 0;
	static PriorityQueue<Integer> pQueue = new PriorityQueue<>();

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++) {
			pQueue.offer(Integer.parseInt(in.readLine()));
		}
	}

	private static void implement() {
		while(pQueue.size() > 1) {
			int X = pQueue.poll() + pQueue.poll();
			cnt += X;
			pQueue.offer(X);
		}
	}

	private static void print() {
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
