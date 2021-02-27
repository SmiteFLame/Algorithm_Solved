package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2075 {
	static int N;
	static int[][] data;
	static PriorityQueue<dataStructure> pQueue = new PriorityQueue<>();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class dataStructure implements Comparable<dataStructure> {
		int num, i, j;

		public dataStructure(int num, int i, int j) {
			this.num = num;
			this.i = i;
			this.j = j;
		}

		public int compareTo(dataStructure o) {
			return o.num - this.num;
		}

	}

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N - 1][N];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int j = 0; j < N; j++) {
			pQueue.offer(new dataStructure(Integer.parseInt(st.nextToken()), N - 1, j));
		}

	}

	private static void implement() {
		for (int i = 0; i < N - 1; i++) {
			dataStructure temp = pQueue.poll();
			if (temp.i > 0) {
				pQueue.offer(new dataStructure(data[temp.i - 1][temp.j], temp.i - 1, temp.j));
			}
		}
	}

	private static void print() {
		System.out.println(pQueue.poll().num);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
