package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17136 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static ArrayList<int[]> arrayList = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int[][] data = new int[10][10];
	static int[] paper = new int[6];

	private static boolean canMove(int X, int Y) {
		if (X < 0 || Y < 0 || X >= 10 || Y >= 10) {
			return false;
		}
		return true;
	}

	private static int checkData(int X, int Y) {
		nextNumber: for (int x = 5; x >= 1; x--) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {
					if (canMove(X + i, Y + j) && data[X + i][Y + j] == 1)
						continue;
					continue nextNumber;
				}
			}
			return x;
		}
	return -1;
	}

	private static void init() throws IOException {
//		데이터 입력
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 10; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 1)
					arrayList.add(new int[] { i, j });
			}
		}

	}

	private static void masking(int X, int Y, int cnt, int by) {
		for (int i = X; i < X + cnt; i++) {
			for (int j = Y; j < Y + cnt; j++) {
				data[i][j] = by;
			}
		}
	}

//	backTacking
	private static void implement(int idx, int cnt) {
		if (idx == arrayList.size()) {
			min = cnt < min ? cnt : min;
			return;
		}

		if (cnt >= min)
			return;

		int[] now = arrayList.get(idx);
		if (data[now[0]][now[1]] == 0) {
			implement(idx + 1, cnt);
			return;
		}
		for (int i = checkData(now[0], now[1]); i >= 1; i--) {
			if (paper[i] >= 5)
				continue;
			masking(now[0], now[1], i, 0);
			paper[i]++;
			implement(idx + 1, cnt + 1);
			paper[i]--;
			masking(now[0], now[1], i, 1);
		}

	}

	private static void print() {
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement(0, 0);
		print();
	}

}
