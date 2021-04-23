package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_17143_양동혁 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static int R, C, M, answer;

	static class shark {
		int R, C, S, D, Z;

		public shark(int r, int c, int s, int d, int z) {
			R = r;
			C = c;
			S = s;
			D = d;
			Z = z;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] sharkNumber = new int[R][C];
		shark[] sharkList = new shark[M + 1];

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			if(d == 0 || d == 1) {
				s %= (2 * (R - 1));
			} else {
				s %= (2 * (C - 1));
			}
			
			sharkNumber[r][c] = m;
			sharkList[m] = new shark(r, c, s, d, z);
		}

		for (int c = 0; c < C; c++) {
			// 1. 가장 가까운 상어를 잡는다.
			int nowShark = 0;
			for (int r = 0; r < R; r++) {
				if (sharkNumber[r][c] == 0)
					continue;
				nowShark = sharkNumber[r][c];
				sharkNumber[r][c] = 0;
				break;
			}

			// 1.1 상어를 잡는다.
			if (nowShark != 0) {
				answer += sharkList[nowShark].Z;
				sharkList[nowShark] = null;
			}

			// 2. 상어들이 움직인다.
			int[][] newSharkNumber = new int[R][C];
			for (int m = 1; m <= M; m++) {
				shark shk = sharkList[m];
				if (shk == null)
					continue;

				// 계속 이동
				for (int s = 0; s < shk.S; s++) {
					if (shk.R == R - 1 && shk.D == 1) {
						shk.D = 0;
					} else if (shk.R == 0 && shk.D == 0) {
						shk.D = 1;
					}
					if (shk.C == C - 1 && shk.D == 2) {
						shk.D = 3;
					} else if (shk.C == 0 && shk.D == 3) {
						shk.D = 2;
					}
					shk.R += NEWS[shk.D][0];
					shk.C += NEWS[shk.D][1];
				}

				if (newSharkNumber[shk.R][shk.C] != 0) {
					int next = newSharkNumber[shk.R][shk.C];
					if (sharkList[next].Z < sharkList[m].Z) {
						sharkList[next] = null;
						newSharkNumber[shk.R][shk.C] = m;
					} else {
						sharkList[m] = null;
					}
				} else {
					newSharkNumber[shk.R][shk.C] = m;
				}
			}
			sharkNumber = newSharkNumber;
		}
		System.out.println(answer);
	}
}
