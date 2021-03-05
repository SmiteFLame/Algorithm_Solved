package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11376 {
	static int N, M, X, ans;
	static int[][] data;
	static int[] matched;
	static boolean[] visited;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0, end = Integer.parseInt(st.nextToken()); j < end; j++) {
				data[i][Integer.parseInt(st.nextToken()) - 1] = 1;
			}
		}
	}


	private static boolean check(int employee) {
		if (visited[employee])
			return false;
		visited[employee] = true;

		for (int task = 0; task < M; task++) {
			if (data[employee][task] == 1) {

				if (matched[task] == -1 || check(matched[task])) {
					matched[task] = employee;
					return true;
				}
			}
		}

		return false;
	}
	
	private static void implement() {
		matched = new int[M];
		Arrays.fill(matched, -1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				visited = new boolean[N];
				if (check(i)) {
					ans++;
				}
			}
		}
	}
	
	private static void print() {
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		implement();
		print();
	}


}
