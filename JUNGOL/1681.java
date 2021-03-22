package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, min;
	static int[][] data;

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
	}

	private static void backTracking(int start, int now, int flag, int sum) {

		if (sum > min) {
			return;
		}

		if (flag == (1 << N) - 1) {
			if (data[now][start] != 0)
				min = sum + data[now][start] < min ? sum + data[now][start] : min;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			if (data[now][i] == 0)
				continue;
			backTracking(start, i, flag | (1 << i), sum + data[now][i]);
		}
	}

	private static void implement() {
		for (int i = 0; i < N; i++) {
			backTracking(i, i, 1 << i, 0);
		}
	}

	private static void print() {
		System.out.println(min);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
