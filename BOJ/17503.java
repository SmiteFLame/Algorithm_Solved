package dongguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17503 {
	static int N, K;
	static long M, min = Long.MAX_VALUE;
	static boolean flag = false;
	static int[][] data;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[K][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(io.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
	}
	
	private static void implement() {
		long sum = 0;
		for (int i = 0; i < K; i++) {
			pq.offer(data[i][0]);
			sum += data[i][0];
			if (pq.size() > N) {
				sum -= pq.poll();
			}
			if (pq.size() == N && sum >= M) {
				min = data[i][1];
				return;
			}
		}
	}

	private static void print() {
		System.out.println(min == Long.MAX_VALUE ? -1 : min);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
