package dongguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {
	static int N, min = Integer.MAX_VALUE;
	static int[] people;
	static ArrayList<Integer>[] map;
	static Queue<Integer> queue = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());

		people = new int[N];
		map = new ArrayList[N];

		st = new StringTokenizer(io.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
			st = new StringTokenizer(io.readLine());
			for (int j = 0, end = Integer.parseInt(st.nextToken()); j < end; j++) {
				map[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
	}

	private static void checkpass(int flag) {
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0)
				continue;
			queue.offer(i);
			visited[i] = true;
			while (!queue.isEmpty()) {
				int X = queue.poll();
				first.add(X);
				for (Integer j : map[X]) {
					if ((flag & 1 << j) == 0 || visited[j])
						continue;
					visited[j] = true;
					queue.offer(j);
				}
			}
			break;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			queue.offer(i);
			visited[i] = true;
			while (!queue.isEmpty()) {
				int X = queue.poll();
				second.add(X);
				for (Integer j : map[X]) {
					if ((flag & 1 << j) != 0 || visited[j])
						continue;
					visited[j] = true;
					queue.offer(j);
				}
			}
			break;
		}
		if (first.size() + second.size() != N) {
			return;
		}

		int dv,sumF = 0,sumS = 0;
		for(Integer f : first) {
			sumF += people[f];
		}
		for(Integer s : second) {
			sumS += people[s];
		}
		dv = Math.abs(sumF - sumS);
		min = dv < min ? dv : min;
	}

	private static void implement() {
		for (int i = 0, end = 1 << (N - 1); i < end; i++) {
			checkpass(i);
		}
	}

	private static void print() {
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
