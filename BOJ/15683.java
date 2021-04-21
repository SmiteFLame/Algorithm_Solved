package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_15683_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	static int N, M, answer;
	static int[][] map;

	static ArrayList<int[]> camera = new ArrayList<>();

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= M || map[X][Y] == 6);
	}

	private static boolean[][] copyVisited(boolean[][] visited) {
		boolean[][] newVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newVisited[i][j] = visited[i][j];
			}
		}
		return newVisited;
	}

	private static void watch(int idx, boolean[][] visited) {
		if (idx == camera.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						continue;
					cnt++;
				}
			}
         	answer = answer < cnt ? answer : cnt;
			return;
		}

		int now[] = camera.get(idx);

		if (now[2] == 1) {
			for (int x = 0; x < 4; x++) {
				boolean[][] newVisited = copyVisited(visited);
				int nx = now[0];
				int ny = now[1];
				while (canMove(nx, ny)) {
					newVisited[nx][ny] = true;
					nx += NEWS[x][0];
					ny += NEWS[x][1];
				}                         
				watch(idx + 1, newVisited);
			}
		} else if (now[2] == 2) {
			for (int x = 0; x < 2; x++) {
				boolean[][] newVisited = copyVisited(visited);
				for (int y = 0; y < 2; y++) {
					int nx = now[0];
					int ny = now[1];
					while (canMove(nx, ny)) {
						newVisited[nx][ny] = true;
						nx += NEWS[x + y * 2][0];
						ny += NEWS[x + y * 2][1];
					}
				}
				watch(idx + 1, newVisited);
			}
		} else if (now[2] == 3) {
			for (int x = 0; x < 4; x++) {
				boolean[][] newVisited = copyVisited(visited);
				for (int y = 0; y < 2; y++) {
					int nx = now[0];
					int ny = now[1];
					int next = x + y == 4 ? 0 : x + y;
					while (canMove(nx, ny)) {
						newVisited[nx][ny] = true;
						nx += NEWS[next][0];
						ny += NEWS[next][1];
					}
				}
				watch(idx + 1, newVisited);
			}
		} else if (now[2] == 4) {
			for (int x = 0; x < 4; x++) {
				boolean[][] newVisited = copyVisited(visited);
				for (int y = 0; y < 4; y++) {
					if (x == y)
						continue;
					int nx = now[0];
					int ny = now[1];
					while (canMove(nx, ny)) {
						newVisited[nx][ny] = true;
						nx += NEWS[y][0];
						ny += NEWS[y][1];
					}
				}
				watch(idx + 1, newVisited);
			}
		} else if (now[2] == 5) {
			boolean[][] newVisited = copyVisited(visited);
			for (int x = 0; x < 4; x++) {
				int nx = now[0];
				int ny = now[1];

				while (canMove(nx, ny)) {
					newVisited[nx][ny] = true;
					nx += NEWS[x][0];
					ny += NEWS[x][1];
				}
			}
			watch(idx + 1, newVisited);
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = N * M;
		boolean[][] visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					camera.add(new int[] { i, j, map[i][j] });
				} else if (map[i][j] == 6) {
					visited[i][j] = true;
				}
			}
		}

		watch(0, visited);
		System.out.println(answer);
	}

}
