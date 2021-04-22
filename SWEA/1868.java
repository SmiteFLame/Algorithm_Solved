package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_D4_1868_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));

	static final int[][] NEWS8 = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	static int N, answer;
	static boolean[][] visited;
	static int[][] map;

	static PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[2], o2[2]);
		}

	});

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				String S = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = S.charAt(j) == '*' ? -1 : 0;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == -1)
						continue;
					int cnt = 0;
					for (int x = 0; x < 8; x++) {
						if (canMove(i + NEWS8[x][0], j + NEWS8[x][1]) && map[i + NEWS8[x][0]][j + NEWS8[x][1]] == -1)
							cnt++;
					}
					map[i][j] = cnt;
					pQueue.add(new int[] { i, j, map[i][j] });
				}
			}

			while (!pQueue.isEmpty()) {
				int[] now = pQueue.poll();
				if (visited[now[0]][now[1]])
					continue;
				visited[now[0]][now[1]] = true;
				answer++;
				if (now[2] == 0) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { now[0], now[1] });
					while (!queue.isEmpty()) {
						int[] next = queue.poll();
						for (int x = 0; x < 8; x++) {
							int nx = next[0] + NEWS8[x][0];
							int ny = next[1] + NEWS8[x][1];
							
							if (!canMove(nx, ny) || visited[nx][ny])
								continue;
							
							visited[nx][ny] = true;
							
							if (map[nx][ny] == 0)
								queue.add(new int[] { nx, ny });
						}
					}
				}
			}

			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}
