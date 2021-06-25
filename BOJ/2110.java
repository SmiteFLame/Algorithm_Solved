package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(data);

		int L = 1, R = data[N - 1] - data[0];
		int answer = 0;

		while (L <= R) {
			int M = (L + R) / 2;
			int start = data[0];
			int cnt = 1;

			for (int i = 1; i < N; i++) {
				if (M <= data[i] - start) {
					start = data[i];
					cnt++;
				}
			}

			if (cnt >= C) {
				answer = M;
				L = M + 1;
			} else {
				R = M - 1;
			}
		}

		System.out.println(answer);
	}

}
