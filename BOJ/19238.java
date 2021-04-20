package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	static int N, M, E;
	static int[][] map;
	static pair[] arrive;
	
	static class Node implements Comparable<Node>{
		int X, Y, dir;

		public Node(int x, int y, int dir) {
			X = x;
			Y = y;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			if(this.dir != o.dir) {
				return this.dir - o.dir;
			}
			if(this.X != o.X) {
				return this.X - o.X;
			}
			return this.Y - o.Y;
		}
		
	}
	
	static class pair{
		int X, Y;

		public pair(int x, int y) {
			X = x;
			Y = y;
		}
	}

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N || map[X][Y] == 1);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());

		// 짧은 거리
		// 행번호, 열번호가 작은순
		// 소모한 연량의 2배를 충전

		int TaxiX = Integer.parseInt(st.nextToken()) - 1;
		int TaxiY = Integer.parseInt(st.nextToken()) - 1;
		
		arrive = new pair[M + 2];

		for (int i = 2; i <= M + 1; i++) {
			st = new StringTokenizer(in.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;
			arrive[i] = new pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}
		int cnt = 0;
		for (cnt = 0; cnt < M; cnt++) {
			int used = 0;

			int nextCustomer = 0;

			boolean[][] visited = new boolean[N][N];
			visited[TaxiX][TaxiY] = true;

			// 위치 찾기
			PriorityQueue<Node> queue = new PriorityQueue<>();
			queue.add(new Node(TaxiX, TaxiY, 0 ));
			while (!queue.isEmpty()) {
				Node now = queue.poll();

				if(map[now.X][now.Y] > 1) {
					nextCustomer = map[now.X][now.Y];
					used = now.dir;
					TaxiX = now.X;
					TaxiY = now.Y;
					break;
				}
				
				for (int x = 0; x < 4; x++) {
					int nx = now.X + NEWS[x][0];
					int ny = now.Y + NEWS[x][1];

					if (!canMove(nx, ny) || visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, now.dir + 1));

				}
			}

			int usedTemp = used;
			if (nextCustomer == 0)
				break;

			visited = new boolean[N][N];
			visited[TaxiX][TaxiY] = true;
			map[TaxiX][TaxiY] = 0;

			// 도착하기
			queue.clear();
			queue.add(new Node(TaxiX, TaxiY, used ));
			
			while (!queue.isEmpty()) {
				Node now = queue.poll();

				if(now.X == arrive[nextCustomer].X && now.Y == arrive[nextCustomer].Y) {
					nextCustomer = 0;
					used = now.dir;
					TaxiX = now.X;
					TaxiY = now.Y;
					break;
				}
				
				for (int x = 0; x < 4; x++) {
					int nx = now.X + NEWS[x][0];
					int ny = now.Y + NEWS[x][1];

					if (!canMove(nx, ny) || visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, now.dir + 1));
					
				}
			}

			if (used > E)
				break;

			if (nextCustomer != 0)
				break;
			
			E = (E - used) + (used - usedTemp) * 2;
		}

		System.out.println(cnt == M ? E : -1);

	}

}
