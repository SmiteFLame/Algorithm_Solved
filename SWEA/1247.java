package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_¾çµ¿Çõ {
	static int T, N, dst, mindist;
	static int[][] location;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		st = new StringTokenizer(io.readLine());
		location = new int[N + 2][2];
		for(int i = 0; i < N + 2; i++) {
			location[i][0] = Integer.parseInt(st.nextToken());
			location[i][1] = Integer.parseInt(st.nextToken());
		}
		mindist = Integer.MAX_VALUE;
	}
	
	private static int dist(int x, int y) {
		return Math.abs(location[x][0] - location[y][0]) + Math.abs(location[x][1] - location[y][1]);
	}
	
	private static void backTracking(int cnt, int idx, int flag, int sum) {
		if(cnt == N) {
			int temp = sum + dist(idx, 1);
			mindist = temp < mindist ? temp : mindist;
			return;
		}
		
		for(int i = 2; i < N + 2; i++) {
			if((flag & 1 << i) != 0) continue;
			
			dst = dist(idx, i);
			if(sum + dst > mindist) continue;
			
			backTracking(cnt + 1, i, flag | 1 << i, sum + dst);
		}
	}
	
	private static void print(int tc) {
		sb.append("#" + " " + tc + " " + mindist + "\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(io.readLine());
		for(int test_case = 1; test_case <= 10; test_case++) {
			init();
			backTracking(0, 0, 0, 0);
			print(test_case);
		}
		System.out.println(sb.toString());
	}

}d
