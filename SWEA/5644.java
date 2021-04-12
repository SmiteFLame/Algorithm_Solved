package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5644 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int M, A;
	static int answer = 0;

	static int[][] move;
	static int[][] BC;

	static int[] power;

	static int[][] NEWS = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static boolean canMove(int X, int Y) {
		if (X < 1 || Y < 1 || X > 10 || Y > 10) {
			return false;
		}
		return true;
	}

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		answer = 0;

		move = new int[2][M + 1];
		BC = new int[11][11];
		power = new int[A];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(in.readLine());
			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int range = Integer.parseInt(st.nextToken());
			power[i] = Integer.parseInt(st.nextToken());

			for (int k = -range; k <= range; k++) {
				for (int l = -range + Math.abs(k), end = range - Math.abs(k); l <= end; l++) {
					int nx = X + k;
					int ny = Y + l;
					if (!canMove(nx, ny))
						continue;
					BC[nx][ny] |= (1 << i);
				}
			}
		}

	}

	private static void moving() {
		int nowAX = 1, nowAY = 1, nowBX = 10, nowBY = 10;
		for (int i = 0; i <= M; i++) {

			// 이동
			nowAX += NEWS[move[0][i]][0];
			nowAY += NEWS[move[0][i]][1];
			nowBX += NEWS[move[1][i]][0];
			nowBY += NEWS[move[1][i]][1];

			int ABC = BC[nowAX][nowAY];
			int BBC = BC[nowBX][nowBY];
			// 2개만 선택

			// 2개를 골랐을 때 가장 큰 값 2개를 찾기
			int max = 0;
			if (ABC == 0) {
				for (int k = 0; k < A; k++) {
					if((BBC & (1 << k)) == 0) continue;
					max = power[k] > max ? power[k] : max;
				}
			} else if (BBC == 0) {
				for (int k = 0; k < A; k++) {
					if((ABC & (1 << k)) == 0) continue;
					max = power[k] > max ? power[k] : max;
				}
			} else {
				for (int k = 0; k < A; k++) {
					if((ABC & (1 << k)) == 0) continue;
					for (int l = 0; l < A; l++) {
						if ((BBC & (1 << l)) == 0) continue;
						if(k == l) max = power[k] > max ? power[k] : max;
						else  max = power[k] + power[l] > max ? power[k] + power[l] : max;
					}
				}
			}

			answer += max;
		}
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			init();
			moving();
			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}
