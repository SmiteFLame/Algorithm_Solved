package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743 {

	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(io.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] NEWS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(io.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j])
					continue;
				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] { i, j });
				map[i][j] = false;
				int count = 1;
				while (!queue.isEmpty()) {
					int[] X = queue.poll();
					for(int k = 0; k < 4; k++) {
						int nx = X[0] + NEWS[k][0];
						int ny = X[1] + NEWS[k][1];
						if(nx < 0 || nx >= N || ny < 0 || ny >= M || !map[nx][ny]) continue;
						queue.add(new int[] {nx, ny});
						map[nx][ny] = false;
						count++;
					}
				}
				max = count > max ? count : max;
			}
		}
		
		System.out.println(max);
	}

}
