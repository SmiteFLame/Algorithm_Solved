package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int N, M, cnt;
	static int[][] tomato;
	static Queue<int[]> queue = new LinkedList<>();

	private static boolean canMove(int X, int Y) {
		if(X < 0 || Y < 0 || X >= N || Y >= M) {
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					queue.offer(new int[] { i, j });
				} else if(tomato[i][j] == 0) {
					tomato[i][j] = Integer.MAX_VALUE;
					cnt++;
				}
			}
		}
		int day = 1;
		while (!queue.isEmpty()) {
			for(int i = 0, end = queue.size(); i < end; i++) {
				int[] now = queue.poll();
				for(int x = 0; x < 4; x++) {
					int nx = now[0] + NEWS[x][0];
					int ny = now[1] + NEWS[x][1];
					if(!canMove(nx, ny) || tomato[nx][ny] <= day) continue;
					tomato[nx][ny] = day;
					queue.offer(new int[] {nx, ny});
					cnt--;
				}
			}
			day++;
		}
		
		System.out.println(cnt == 0 ? day - 2 : -1);
	}
}
