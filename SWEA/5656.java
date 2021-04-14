package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static final int[][] NEWS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int N, W, H, answer;
	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= H || Y >= W);
	}

	private static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}

		return newMap;
	}

	private static void permutation(int cnt, int[][] map) {
		if (cnt <= N) {
			int sum = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sum = map[i][j] == 0 ? sum : sum + 1;
				}
			}			
			answer = sum < answer ? sum : answer;
			
			if(cnt == N) return;
		}

		for (int w = 0; w < W; w++) {

			// 맨 위 찾기
			int top = 0;

			for (; top < H; top++) {
				if (map[top][w] != 0)
					break;
			}

			// 아무것도 없는 경우 패스
			if (top == H)
				continue;

			// 1. 터트리기
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { top, w, map[top][w] });
			
			int[][] newMap = copyMap(map);
			newMap[top][w] = 0;

			while (!queue.isEmpty()) {
				int[] now = queue.poll();

				for (int m = 1, end = now[2]; m < end; m++) {
					for (int x = 0; x < 4; x++) {
						int nx = now[0] + NEWS[x][0] * m;
						int ny = now[1] + NEWS[x][1] * m;
						if (!canMove(nx, ny))
							continue;
						queue.add(new int[] { nx, ny, newMap[nx][ny] });
						newMap[nx][ny] = 0;
					}
				}
			}

			// 2. 내리기
			for(int j = 0; j < W; j++) {
				for(int i = H - 1; i > 0; i--) {
					if(newMap[i][j] != 0) continue;
					
					for(int k = i - 1; k >= 0; k--) {
						if(newMap[k][j] == 0) continue;
						
						newMap[i][j] = newMap[k][j];
						newMap[k][j] = 0;
						break;
					}
				}
			}

			permutation(cnt + 1, newMap);

		}
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			// 데이터 입력
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			
			answer = H * W;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(0, map);
			
			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}

}
