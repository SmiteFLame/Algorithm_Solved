import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int R, C;
	static char arr[][];
	static boolean visit[][];

	public static class Po {
		int x;
		int y;
		int cnt;

		public Po(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= C || Y >= R);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int answer = 0;
		Queue<Po> queue = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != 'L')
					continue;
				
				visit = new boolean[R][C];

				int now = 0;
				visit[i][j] = true;
				queue.add(new Po(j, i, 0));
				while (!queue.isEmpty()) {
					Po p = queue.poll();
					for (int d = 0; d < 4; d++) {
						int nx = p.x + NEWS[d][0];
						int ny = p.y + NEWS[d][1];
						if (!canMove(nx, ny) || visit[ny][nx] || arr[ny][nx] != 'L')
							continue;
						visit[ny][nx] = true;
						queue.add(new Po(nx, ny, p.cnt + 1));
						now = now > p.cnt + 1 ? now : p.cnt + 1;
					}
				}

				answer = answer > now ? answer : now;

			}
		}

		System.out.println(answer);

	}
}
