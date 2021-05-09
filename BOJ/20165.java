package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20165 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

	static int N, M, R;
	static int[][] map;
	static boolean[][] domino;

	private static int getDir(char X) {
		switch (X) {
		case 'N':
			return 0;
		case 'E':
			return 1;
		case 'W':
			return 2;
		case 'S':
			return 3;
		}
		return -1;
	}
	
	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= M);
	}

	private static int attack() throws IOException {
		int sum = 0;
		
		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		int dir = getDir(st.nextToken().charAt(0));

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		domino[x][y] = true;

		while (!queue.isEmpty()) {
			sum++;
			int[] now = queue.poll();
	
			for(int i = 0; i < map[now[0]][now[1]]; i++) {
				int nx = now[0] + NEWS[dir][0] * i;
				int ny = now[1] + NEWS[dir][1] * i;
				if(!canMove(nx, ny) || domino[nx][ny]) continue;
				domino[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}

		return sum;
	}

	private static void defense() throws IOException {
		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		domino[x][y] = false;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		domino = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int r = 0; r < R; r++) {
			answer += attack();
			defense();
		}
		System.out.println(answer);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(domino[i][j] ? "F " : "S ");
			}
			System.out.println();
		}
	}
}
