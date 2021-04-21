package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_양동혁 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int N, M, answer;
	static char[][] map;

	static boolean[][][] visited;

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= M || map[X][Y] == '#');
	}

	private static void BFS(int X, int Y, int flag, int cnt) {

		// 현재 키를 가지고 있는 상태에서 BFS 시작
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		visited = new boolean[N][M][1 << 7];

		answer = Integer.MAX_VALUE;
		int startX = 0, startY = 0;
		for (int i = 0; i < N; i++) {
			String S = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j);
				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		visited[startX][startY][0] = true;
		queue.add(new int[] { startX, startY, 0, 0 });

		
		BFS:
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int x = 0; x < 4; x++) {
				int nx = now[0] + NEWS[x][0];
				int ny = now[1] + NEWS[x][1];
				int nk = now[3];

				// 움직이지 못하거나 방문 했다면 pass
				if (!canMove(nx, ny))
					continue;

				// 키를 발견 한 경우
				if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					nk |= (1 << map[nx][ny] - 'a');

					// 문에 도착 했을 떄 키가 있는 경우에만 통과
				} else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					if ((nk & (1 << (map[nx][ny] - 'A'))) == 0)
						continue;

					// 도착 했다면 최신값 갱신
				} else if (map[nx][ny] == '1') {
					answer = now[2] + 1;
					break BFS;
					// 빈칸이라면 움직임
				}
				
				if(visited[nx][ny][nk]) continue;

				visited[nx][ny][nk] = true;
				queue.add(new int[] { nx, ny, now[2] + 1 , nk});

			}

		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

}
