package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2105_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, answer, max;
	static int[][] data;
	static boolean[] visited;

	static final int[][] diamond = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	
	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}
	
	private static void DFS(int ogi, int ogj, int i, int j, int dir, int cnt) {
		if(dir == 4) {
			return;
		}
		
		int nx = i + diamond[dir][0];
		int ny = j + diamond[dir][1];
		
		if(!canMove(nx, ny)) {
			return;
		}
		
		if(nx == ogi && ny == ogj) {
			
			answer = cnt > answer ? cnt : answer;
			
			return;
		}
		
		if(visited[data[nx][ny]]) {
			return;
		}

		visited[data[nx][ny]] = true;

		DFS(ogi, ogj, nx, ny, dir + 1, cnt + 1);
		DFS(ogi, ogj, nx, ny, dir, cnt + 1);		

		visited[data[nx][ny]] = false;
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			N = Integer.parseInt(in.readLine());
			data = new int[N][N];

			answer = -1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					max = data[i][j] > max ? data[i][j] : max;
				}
			}
			
			visited = new boolean[max + 1];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited[data[i][j]] = true;
					DFS(i, j, i, j, 0, 1);
					visited[data[i][j]] = false;
				}
			}
			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}
