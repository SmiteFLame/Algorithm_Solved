package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_20058 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int N, Q, L, end, sum, maxSize;
	static int[][] map;
	
	private static boolean inIce(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= end || Y >= end || map[X][Y] == 0);
	}

	private static void moving(int level, int size) {
		int next = size * 2;
		for (int i = 0; i < level; i++) {
			for (int j = 0; j < level; j++) {
				int[][] temp = new int[next][next];
				
				for(int k = 0; k < next; k++) {
					for(int l = 0; l < next; l++) {
						temp[k][l] = map[i * next + k][j * next + l];
					}
				}
				for(int k = 0; k < next; k++) {
					for(int l = 0; l < next; l++) {
						map[i * next + k][j * next + l] = temp[next - l - 1][k];
					}
				}
				
			}
		}
	}

	private static void melting() {
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < end; i++) {
			for (int j = 0; j < end; j++) {
				if(map[i][j] == 0) continue;
				int cnt = 0;
				for(int x = 0; x < 4; x++) {
					int nx = i + NEWS[x][0];
					int ny = j + NEWS[x][1];
					if(!inIce(nx, ny)) continue;
					cnt++;
				}
				if(cnt < 3) {
					set.add(Arrays.asList(i, j));
				}
			}
		}
		
		sum -= set.size();
		
		for(List<Integer> s : set) {
			map[s.get(0)][s.get(1)]--;
		}		
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		end = (int) Math.pow(2, N);
		map = new int[end][end];

		for (int i = 0; i < end; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < end; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < Q; i++) {
			L = Integer.parseInt(st.nextToken());
			if (L != 0)
				moving((int) Math.pow(2, N - L), (int) Math.pow(2, L - 1));

			melting();
		}
		System.out.println(sum);
		
		boolean[][] visited = new boolean[end][end];
		
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < end; i++) {
			for(int j = 0; j < end; j++) {
				if(visited[i][j] || map[i][j] == 0) continue;
				int cnt = 0;
				visited[i][j] = true;
				queue.offer(new int[] {i, j});
				while(!queue.isEmpty()) {
					int[] now = queue.poll();
					cnt++;
					for(int x = 0; x < 4; x++) {
						int nx = now[0] + NEWS[x][0];
						int ny = now[1] + NEWS[x][1];
						if(!inIce(nx, ny) || visited[nx][ny]) continue;
						visited[nx][ny] = true;
						queue.offer(new int[] {nx, ny});
					}
				}
				
				maxSize = cnt > maxSize ? cnt : maxSize;
			}
		}
		
		System.out.println(maxSize);
	}

}
