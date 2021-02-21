package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325 {
	static int N, M, X, Y, max;
	static int[] maxList;
	static boolean[] visited;
	static ArrayList<Integer>[] hacklist;

	private static void init() throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		hacklist = new ArrayList[N + 1];
		maxList = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			hacklist[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(io.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			hacklist[X].add(Y);
		}

	}

	private static void DFS(int idx) {
		for(int i : hacklist[idx]) {
			if(visited[i]) continue;
			visited[i] = true;
			maxList[i]++;
			DFS(i);
			max = maxList[i] > max ? maxList[i] : max;
		}
	}

	private static void implement() {
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			DFS(i);
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (maxList[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}
}
