package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17144 {
	static int R, C, T, ans, nx, ny;
	static int[][] data, dataTemp;;
	static int[][] NEWS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<Integer> air = new ArrayList<>();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		data = new int[R][C];
		dataTemp = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == -1) {
					air.add(i);
				}
			}
		}
	}

	private static boolean canMove(int X, int Y) {
		if (X < 0 || X >= R || Y < 0 || Y >= C) {
			return false;
		} else if ((X == air.get(0) || X == air.get(1)) && (Y == 0)) {
			return false;
		}
		return true;
	}

	private static void moveDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (data[i][j] == 0 || data[i][j] == -1)
					continue;
				int move = 0;
				int dust = data[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					nx = i + NEWS[k][0];
					ny = j + NEWS[k][1];
					if (!canMove(nx, ny))
						continue;
					dataTemp[nx][ny] += dust;
					move++;
				}
				dataTemp[i][j] += (data[i][j] - dust * move);
			}
		}
	}

	private static void useAir() {
//		1. 위에 있는 것 반시계 방향
		for (int i = air.get(0) - 1; i > 0; i--) {
			dataTemp[i][0] = dataTemp[i - 1][0];
		}
		for (int j = 1; j < C; j++) {
			dataTemp[0][j - 1] = dataTemp[0][j];
		}
		for (int i = 0, end = air.get(0); i < end; i++) {
			dataTemp[i][C - 1] = dataTemp[i + 1][C - 1];
		}
		for (int j = C - 1; j > 0; j--) {
			dataTemp[air.get(0)][j] = dataTemp[air.get(0)][j - 1];
		}
		
//		2. 아래에 있는 것 시계 방향
		for (int i = air.get(1) + 1; i < R - 1; i++) {
			dataTemp[i][0] = dataTemp[i + 1][0];
		}
		for (int j = 1; j < C; j++) {
			dataTemp[R - 1][j - 1] = dataTemp[R - 1][j];
		}
		for (int i = R - 1, end = air.get(1); i > end; i--) {
			dataTemp[i][C - 1] = dataTemp[i - 1][C - 1];
		}
		for (int j = C - 1; j > 0; j--) {
			dataTemp[air.get(1)][j] = dataTemp[air.get(1)][j - 1];
		}
	}

	private static void implement() {
		for (int i = 0; i < T; i++) {
			dataTemp = new int[R][C];
			moveDust();
			useAir();
			data = dataTemp;
		}
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += data[i][j];
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}
}
