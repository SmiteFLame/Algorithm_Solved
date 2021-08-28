import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int[][] NEWS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int[][] NEWS_H = { { -1, 2 }, { 1, 2 }, { -1, -2 }, { 1, -2 }, { -2, 1 }, { 2, 1 }, { -2, -1 },
			{ 2, -1 } };

	static int W, H;

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= H || Y >= W);
	}

	public static void main(String[] args) throws IOException {
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[][]map = new int[H][W];
		boolean[][][] visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int x = 0; x < 4; x++) {
				int nx = now[0] + NEWS[x][0];
				int ny = now[1] + NEWS[x][1];
				if (!canMove(nx, ny) || map[nx][ny] == 1 || visited[nx][ny][now[2]]) continue;
				if(nx == H - 1 && ny == W - 1) {
					System.out.println(now[3] + 1);
					return;
				}
				visited[nx][ny][now[2]] = true;
				queue.add(new int[] {nx, ny, now[2], now[3] + 1});
			}

			if (now[2] == K) continue;
			
			for (int x = 0; x < 8; x++) {
				int nx = now[0] + NEWS_H[x][0];
				int ny = now[1] + NEWS_H[x][1];
				if (!canMove(nx, ny) || map[nx][ny] == 1 ||  visited[nx][ny][now[2] + 1]) continue;
				if(nx == H - 1 && ny == W - 1) {
					System.out.println(now[3] + 1);
					return;
				}
				visited[nx][ny][now[2] + 1] = true;
				queue.add(new int[] {nx, ny, now[2] + 1, now[3] + 1});
			}

		}
		if(W == 1 && H == 1) {
			System.out.println(0);
		}else {
			System.out.println(-1);
		}
	}
}
