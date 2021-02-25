package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767 {
	static int T, N, X, maxCore, minLine, nx, ny;
	static boolean[][] map;
	static int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Pair> data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static class Pair {
		int X;
		int Y;

		Pair(int X, int Y) {
			this.X = X;
			this.Y = Y;
		}
	}

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());

		maxCore = 0;
		minLine = Integer.MAX_VALUE;
		data = new ArrayList<>();
		
		map = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1' ? true : false;
				if (map[i][j]) {
					data.add(new Pair(i, j));
				}
			}
		}

	}
	
	private static boolean[][] clone2des(boolean[][] map) {
		boolean[][] temp = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}
		return temp;
	}
	
	private static boolean canMove(int X, int Y) {
		if(X >= 0 && X < N && Y >= 0 && Y < N) {
			return true;
		}
		return false;
	}
	

	private static void implement(boolean[][] map, int idx, int cnt, int line) {
		if(idx - cnt > data.size() - maxCore) return;
		if (idx == data.size()) {
			if(cnt > maxCore) {
				maxCore = cnt;
				minLine = line;
			} else if(cnt == maxCore) {
				minLine = minLine < line ? minLine : line;
			}
			return;
		}

		next:
		for(int i = 0; i < 4; i++) {
			boolean[][] temp = clone2des(map);
			int count = 0;
			nx = data.get(idx).X;
			ny = data.get(idx).Y;
			while(true) {
				nx += NEWS[i][0];
				ny += NEWS[i][1];
				if(!canMove(nx, ny))break;
				if(temp[nx][ny]) continue next;
				count++;
				temp[nx][ny] = true;
			}
			implement(temp, idx + 1, cnt + 1, line + count);
		}
		implement(map, idx + 1, cnt, line);
	}
	
	private static void print(int tc) throws IOException {
		ot.write("#" + tc + " " + minLine + "\n");
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(io.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			implement(map, 0, 0, 0);
			print(test_case);
		}
		ot.flush();
		ot.close();
	}

}
