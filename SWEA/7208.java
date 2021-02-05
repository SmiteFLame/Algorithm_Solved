package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7208_¾çµ¿Çõ {
	static int T, N, flag;
	static int[] color;
	static int[] temp;
	static boolean[][] map;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void init() throws NumberFormatException, IOException {
		N = Integer.parseInt(io.readLine());
		color = new int[N + 1];
		map = new boolean[N][N];
		st = new StringTokenizer(io.readLine());
		for (int i = 0; i < N; i++) {
			color[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}

		flag = N;
	}

	public static void implement() {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(color);

		queue:
		while (!Q.isEmpty()) {
			int[] pair = Q.poll();

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (map[i][j] && pair[i] == pair[j]) {
						for (int k = 1; k <= 4; k++) {
							temp = Arrays.copyOf(pair, N + 1);
							temp[j] = ++flag;
							temp[N] = pair[N] + 1;
							Q.add(temp);
						}
						continue queue;
					}
				}
			}
			
			sb.append(pair[N]).append("\n");
			break;
		}
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
