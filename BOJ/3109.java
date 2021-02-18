package another;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 식당예제_양동혁 {
	static int R, C, ans;
	static boolean[][] map;
	static String S;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException{
		st = new StringTokenizer(io.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			S = io.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = S.charAt(j) == 'x' ? true : false;
			}
		}
	}
	
	private static void implement() {
		for(int i = 0; i < R; i++) {
			backTracking(i, 0);
		}
	}
	
	private static boolean backTracking(int r, int c) {

		if(map[r][c]) return false;
		
		map[r][c] = true;
		
		if(c == C - 1) {
			ans++;
			return true;
		}
		
		if(r > 0 && backTracking(r - 1, c + 1)) return true;
		if(backTracking(r, c + 1)) return true;
		if(r < R - 1 && backTracking(r + 1, c + 1)) return true;
		
//		map[r][c] = false;
		return false;
	}
	
	private static void print() {
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();
	}

}
