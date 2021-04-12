package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[][] map;
	static int[][] dist;

	static final int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			String S = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		dist[0][0] = 0;
	}
	
	private static boolean canMove(int X, int Y) {
		if(X < 0 || Y < 0 || X >= N || Y >= N) {
			return false;
		}
		return true;
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int x = 0; x < 4; x++) {
				int nx = now[0] + NEWS[x][0];
				int ny = now[1] + NEWS[x][1];
				
				if(!canMove(nx, ny)) continue;
				
				if(dist[nx][ny] > dist[now[0]][now[1]] + map[nx][ny]) {
					dist[nx][ny] = dist[now[0]][now[1]] + map[nx][ny];
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			init();
			bfs();
			ot.write("#" + tc + " " + dist[N - 1][N - 1] + "\n");
		}
		ot.flush();
		ot.close();
	}

}
