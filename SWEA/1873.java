package swea;

import java.util.Scanner;

public class Solution_D3_1873_¾çµ¿Çõ {
	static int T, H, W, N;
	static char[][] map;
	static String S;

	static int[] tankLocation = new int[3];

	static StringBuilder st = new StringBuilder();

	// ºÏ, ³², µ¿, ¼­
	static int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int rotationToInt(char C) {
		if (C == '<' || C == 'L') {
			return 3;
		} else if (C == '>' || C == 'R') {
			return 2;
		} else if (C == 'v' || C == 'D') {
			return 1;
		} else if (C == '^' || C == 'U') {
			return 0;
		} else {
			return -1;
		}
	}

	public static char intToRotation(int C) {
		if (C == 3) {
			return '<';
		} else if (C == 2) {
			return '>';
		} else if (C == 1) {
			return 'v';
		} else if (C == 0) {
			return '^';
		} else {
			return ' ';
		}
	}

	public static void tankinit(int X, int Y, char C) {
		map[X][Y] = '.';
		tankLocation[0] = X;
		tankLocation[1] = Y;
		tankLocation[2] = rotationToInt(C);
	}

	public static boolean canMove(int X, int Y, boolean shooting) {
		if (X < 0 || X >= H || Y < 0 || Y >= W)
			return false;

		if (map[X][Y] == '.')
			return true;

		if (shooting)
			return true;

		return false;
	}

	public static void shoot() {
		int dX = tankLocation[0] + NEWS[tankLocation[2]][0];
		int dY = tankLocation[1] + NEWS[tankLocation[2]][1];

		while (canMove(dX, dY, true)) {
			if (map[dX][dY] == '*') {
				map[dX][dY] = '.';
				break;
			}
			if (map[dX][dY] == '#') {
				break;
			}
			dX += NEWS[tankLocation[2]][0];
			dY += NEWS[tankLocation[2]][1];
		}

	}

	public static void move(char C) {
		tankLocation[2] = rotationToInt(C);

		if (canMove(tankLocation[0] + NEWS[tankLocation[2]][0], tankLocation[1] + NEWS[tankLocation[2]][1], false)) {
			tankLocation[0] += NEWS[tankLocation[2]][0];
			tankLocation[1] += NEWS[tankLocation[2]][1];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				S = sc.next();
				for (int j = 0; j < W; j++) {
					if (rotationToInt(S.charAt(j)) == -1) {
						map[i][j] = S.charAt(j);
					} else {
						tankinit(i, j, S.charAt(j));
					}
				}
			}

			N = sc.nextInt();
			S = sc.next();
			for (int k = 0; k < N; k++) {
				if (S.charAt(k) == 'S')
					shoot();
				else
					move(S.charAt(k));
			}

			map[tankLocation[0]][tankLocation[1]] = intToRotation(tankLocation[2]);

			st.append("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					st.append(map[i][j]);
				}
				st.append("\n");
			}

		}
		System.out.println(st.toString());
	}
}
