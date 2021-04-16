package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2105_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, answer;
	static int[][] data;
	static Set<Integer> set = new HashSet<>();

	static final int[][] diamond = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	
	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}
	
	private static void DFS(int ogi, int ogj, int i, int j, int dir) {
		if(dir == 4) {
			return;
		}
		
		set.add(data[i][j]);
		
		int nx = i + diamond[dir][0];
		int ny = j + diamond[dir][1];
		
		if(!canMove(nx, ny)) {
			return;
		}
		
		if(nx == ogi && ny == ogj) {
			
			answer = set.size() > answer ? set.size() : answer;
			
			return;
		}
		
		if(set.contains(data[nx][ny])) {
			return;
		}
		
		set.add(data[nx][ny]);

		DFS(ogi, ogj, nx, ny, dir + 1);
		DFS(ogi, ogj, nx, ny, dir);		

		set.remove(data[nx][ny]);
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
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					set.add(data[i][j]);
					DFS(i, j, i, j, 0);
					set.clear();
				}
			}
			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}
