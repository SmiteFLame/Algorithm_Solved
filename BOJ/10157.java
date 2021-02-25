package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157 {
	static int N, M, K, X, Y, nx, ny;
	static int[][] NEWS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] map;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(io.readLine());
		
		map = new boolean[N][M];
	}

	private static void implement() {
		int idx = 0;
		if(K > N * M) return;
		while (--K > 0) {
			map[X][Y] = true;
			
			nx = X + NEWS[idx][0];
			ny = Y + NEWS[idx][1];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny]) {
				idx = idx == 3 ? 0 : idx + 1;
				nx = X + NEWS[idx][0];
				ny = Y + NEWS[idx][1];
			}
			X = nx;
			Y = ny;
		}
	}
	
	private static void print() {
		if(K > N * M) System.out.println(0);
		else System.out.println((X + 1) + " " + (Y + 1));
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
