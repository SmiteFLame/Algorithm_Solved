package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G4_1987_¾çµ¿Çõ {
	static int R, C, nr, nc, max;
	static char[][] map;
	static int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[] visited = new boolean[26];
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = io.readLine().toCharArray();
		}
	}
	
	private static boolean canNotMove(int x, int y) {
		if(x < 0 || y < 0 || x >= R || y >= C ) return true;
		return false;
	}

	private static void implement(int r, int c, int cnt) {
		visited[map[r][c] - 'A'] = true;
		max = cnt > max ? cnt : max;
		for (int i = 0; i < 4; i++) {
			nr = r + NEWS[i][0];
			nc = c + NEWS[i][1];
			if(canNotMove(nr, nc) || visited[map[nr][nc] - 'A']) continue;
			implement(nr, nc, cnt + 1);
		}
		visited[map[r][c] - 'A'] = false;
	}

	private static void print() {
		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement(0, 0, 1);
		print();
	}

}
