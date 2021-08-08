import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N, mapNumber;
	static int[][] data;
	static int[][] map;

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> corner = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j] != 1)
					continue;
				mapNumber++;
				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] { i, j });
				map[i][j] = mapNumber;
				data[i][j] = -1;
				while (!queue.isEmpty()) {
					int[] now = queue.poll();
					boolean isCorner = false;
					for (int x = 0; x < 4; x++) {
						int nx = now[0] + NEWS[x][0];
						int ny = now[1] + NEWS[x][1];
						if (!canMove(nx, ny))
							continue;
						if (data[nx][ny] != 1) {
							if (data[nx][ny] == 0) {
								isCorner = true;
							}
							continue;
						}
						queue.add(new int[] { nx, ny });
						map[nx][ny] = mapNumber;
						data[nx][ny] = -1;
					}
					if (isCorner) {
						corner.add(new int[] { now[0], now[1], mapNumber });
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = data[i][j] == 0 ? -1 : 0;
			}
		}

		for (int[] cor : corner) {
			data[cor[0]][cor[1]] = 1;
		}

		int answer = Integer.MAX_VALUE;
		while (!corner.isEmpty()) {
			int[] now = corner.poll();
			for (int x = 0; x < 4; x++) {
				int nx = now[0] + NEWS[x][0];
				int ny = now[1] + NEWS[x][1];
				if (!canMove(nx, ny) || data[nx][ny] == 0) {
					continue;
				}
				if (data[nx][ny] == -1) {
					data[nx][ny] = data[now[0]][now[1]] + 1;
					map[nx][ny] = now[2];
					corner.add(new int[] { nx, ny, now[2] });
				} else if (map[nx][ny] == map[now[0]][now[1]]) {
					if (data[nx][ny] > data[now[0]][now[1]] + 1) {
						data[nx][ny] = data[now[0]][now[1]] + 1;
						corner.add(new int[] { nx, ny, now[2] });
					}
				} else {
					int next = data[nx][ny] + data[now[0]][now[1]];
					answer = next < answer ? next : answer;
				}
			}
		}
		System.out.println(answer - 2);
	}
}
