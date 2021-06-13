package ssaft.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2302 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int N, M, max;
	static int[] fixed;
	static int[] fibo;

	private static void makeFibonacci() {
		fibo = new int[max > 3 ? max : 3];
		fibo[1] = 1;
		fibo[2] = 2;
		for (int i = 3; i < max; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		fixed = new int[M + 2];

		// 맨 왼쪽 벽을 고정
		fixed[0] = 0;

		for (int i = 1; i <= M; i++) {
			fixed[i] = Integer.parseInt(in.readLine());
		}

		// 맨 오른쪽 벽을 고정
		fixed[M + 1] = N + 1;

		int answer = 1;

		// 피보나치 수열을 구하기 위한 최대값
		for (int i = 0; i <= M; i++) {
			max = fixed[i + 1] - fixed[i] > max ? fixed[i + 1] - fixed[i] : max;
		}

		makeFibonacci();

		for (int i = 0; i <= M; i++) {
			if (fixed[i + 1] - fixed[i] > 1)
				answer *= fibo[fixed[i + 1] - fixed[i] - 1];
		}

		System.out.println(answer);
	}

}
