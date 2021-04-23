package justonly;

import java.util.Scanner;

public class Main_2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] data = new int[K][N + 1];

		for (int i = 0; i <= N; i++) {
			data[0][i] = 1;
		}

		for (int x = 1; x < K; x++) {
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if (i + j > N)
						break;
					data[x][i + j] = (data[x][i + j] + data[x - 1][j]) % 1000000000;
				}
			}
		}

		System.out.println(data[K - 1][N]);
	}
}
