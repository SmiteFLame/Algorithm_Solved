package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615 {
	static int win, winX, winY;
	static int[][] map;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
	}

	private static boolean findAcrossUp(int X, int Y) {
		if (X < 4 || Y > 14)
			return false;
		int now = map[X][Y];
		for (int i = 1; i < 5; i++) {
			if (map[X - i][Y + i] != now)
				return false;
		}
		if (X - 5 >= 0 && Y + 5 < 19 && map[X - 5][Y + 5] == now)
			return false;
		if (X + 1 < 19 && Y - 1 >= 0 && map[X + 1][Y - 1] == now)
			return false;
		win = map[X][Y];
		winX = X + 1;
		winY = Y + 1;
		return true;
	}

	private static boolean findRight(int X, int Y) {
		if (Y > 14)
			return false;
		int now = map[X][Y];
		for (int i = 1; i < 5; i++) {
			if (map[X][Y + i] != now)
				return false;
		}
		if (Y + 5 < 19 && map[X][Y + 5] == now)
			return false;
		if (Y - 1 >= 0 && map[X][Y - 1] == now)
			return false;
		win = map[X][Y];
		winX = X + 1;
		winY = Y + 1;
		return true;
	}

	private static boolean findAcrossDown(int X, int Y) {
		if (X > 14 || Y > 14)
			return false;
		int now = map[X][Y];
		for (int i = 1; i < 5; i++) {
			if (map[X + i][Y + i] != now)
				return false;
		}
		if (X + 5 < 19 && Y + 5 < 19 && map[X + 5][Y + 5] == now)
			return false;
		if (X - 1 >= 0 && Y - 1 >= 0 && map[X - 1][Y - 1] == now)
			return false;
		win = map[X][Y];
		winX = X + 1;
		winY = Y + 1;
		return true;
	}

	private static boolean findDown(int X, int Y) {
		if (X > 14)
			return false;
		int now = map[X][Y];
		for (int i = 1; i < 5; i++) {
			if (map[X + i][Y] != now)
				return false;
		}
		if (X + 5 < 19 && map[X + 5][Y] == now)
			return false;
		if (X - 1 >= 0 && map[X - 1][Y] == now)
			return false;
		win = map[X][Y];
		winX = X + 1;
		winY = Y + 1;
		return true;
	}

	private static void implement() {
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (map[i][j] == 0)
					continue;
				if (findAcrossUp(i, j) || findRight(i, j) || findAcrossDown(i, j) || findDown(i, j))
					return;
			}
		}
	}

	private static void print() {
		System.out.println(win);
		if (win != 0) {
			System.out.println(winX + " " + winY);
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
