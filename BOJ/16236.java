package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	static int N, size = 2, next, nx, ny, time, checkDist;
	static int[][] map;
	static int[][] dist;
	static int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static Queue<int[]> queue = new LinkedList<>();
	static PriorityQueue<pair> pQ = new PriorityQueue<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class pair implements Comparable<pair>{
		int X;
		int Y;
		pair(int X, int Y){
			this.X = X;
			this.Y = Y;
		}
		@Override
		public int compareTo(pair o) {
			return this.X - o.X != 0 ? this.X - o.X : this.Y - o.Y;
		}
		
	}

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());

		map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					queue.offer(new int[] { i, j });
					initDist(i, j);
					map[i][j] = 0;
				}
			}
		}
	}

	private static boolean canNotMove(int X, int Y) {
		if (X < 0 || X >= N || Y < 0 || Y >= N || map[X][Y] > size) {
			return true;
		}
		return false;
	}

	private static void initDist(int X, int Y) {
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[X][Y] = 0;
		checkDist = Integer.MAX_VALUE;
	}

//	자신과 같으면 지나갈수 있다.

	private static void implement() {
		while (true) {
			while (!queue.isEmpty()) {
				int[] Q = queue.poll();

				for (int i = 0; i < 4; i++) {
					nx = Q[0] + NEWS[i][0];
					ny = Q[1] + NEWS[i][1];
					if (canNotMove(nx, ny))
						continue;

					if (dist[nx][ny] <= dist[Q[0]][Q[1]] + 1)
						continue;
					
					if(dist[Q[0]][Q[1]] + 1 > checkDist)
						continue;

					if (map[nx][ny] != 0 && map[nx][ny] < size) {
						dist[nx][ny] = dist[Q[0]][Q[1]] + 1;
						pQ.offer(new pair(nx, ny));
						checkDist = dist[nx][ny];
						continue;
					}

					dist[nx][ny] = dist[Q[0]][Q[1]] + 1;
					queue.offer(new int[] { nx, ny });
				}
			}
			if (pQ.isEmpty())
				break;

			pair P = pQ.poll();
			next++;
			if (size == next) {
				size++;
				next = 0;
			}
			pQ.clear();
			time += (dist[P.X][P.Y]);
			queue.offer(new int[] { P.X, P.Y });
			initDist(P.X, P.Y);
			map[P.X][P.Y] = 0;
		}
	}

	private static void print() {
		System.out.println(time);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
