import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6953 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int[][] NEWS = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	private static boolean canMove(int X, int Y, int Z, int L, int R, int C) {
		return !(X < 0 || Y < 0 || Z < 0 || X >= L || Y >= R || Z >= C);
	}

	public static void main(String[] args) throws IOException {
		next:
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) {
				bw.flush();
				bw.close();
				return;
			}

			Queue<int[]> queue = new LinkedList<>();

			int[][][] map = new int[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String S = br.readLine();
					for (int k = 0; k < C; k++) {
						switch (S.charAt(k)) {
						case 'S':
							queue.add(new int[] { i, j, k});
							map[i][j][k] = 0;
							break;
						case '#':
							map[i][j][k] = Integer.MIN_VALUE;
							break;
						case 'E':
							map[i][j][k] = -1;
							break;
						default:
							map[i][j][k] = Integer.MAX_VALUE;
							break;
						}

					}
				}
				br.readLine();
			}
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				for(int x = 0; x < 6; x++) {
					int nx = now[0] + NEWS[x][0];
					int ny = now[1] + NEWS[x][1];
					int nz = now[2] + NEWS[x][2];
					if(!canMove(nx, ny, nz, L, R, C)) continue;
					if(map[nx][ny][nz] == -1) {
						bw.write("Escaped in " +(map[now[0]][now[1]][now[2]] + 1) + " minute(s).\n");
						continue next;
					}
					if(map[nx][ny][nz] > map[now[0]][now[1]][now[2]] + 1) {
						map[nx][ny][nz] = map[now[0]][now[1]][now[2]] + 1;
						queue.add(new int[] {nx, ny, nz});
					}
				}
			}
			bw.write("Trapped!\n");
		}
	}

}
