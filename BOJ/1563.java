package ssafy;

import java.util.Scanner;

public class Main_1563 {
	static int N, ans;
	static long[][][] DP;
	static Scanner sc = new Scanner(System.in);

	private static void init() {
		N = sc.nextInt();
//		N개, 결석 , 지각
		DP = new long[N + 1][3][2];
	}

	private static void implement() {
		DP[0][0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
//				1. 결석 없는 경우
				DP[i][0][j] = (DP[i - 1][0][j] + DP[i - 1][1][j] + DP[i - 1][2][j]) % 1000000;
//				2. 결식 1번 있는 경우
				DP[i][1][j] = DP[i - 1][0][j];
//				3. 결식 2번 있는 경우
				DP[i][2][j] = DP[i - 1][1][j];
			}
//			지각 발생하는 경우
			DP[i][0][1] += (DP[i - 1][0][0] + DP[i - 1][1][0] + DP[i - 1][2][0]) % 1000000;

		}
	}

	private static void print() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				ans += DP[N][i][j];
			}
		}
		System.out.println(ans % 1000000);
	}

	public static void main(String[] args) {
		init();
		implement();
		print();
	}

}
