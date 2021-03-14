package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2631 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int N, max;
	static int[] data;
	static int[] DP;

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N];
		DP = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}
	}

	private static void implement() {
		DP[0] = 1;
		for (int i = 1; i < N; i++) {
			DP[i] = 1;
			for(int j = 0; j < i; j++) {
				if(data[i] > data[j]) {
					DP[i] = DP[i] > (DP[j] + 1) ? DP[i] : (DP[j] + 1);
				}
			}
			max = DP[i] > max ? DP[i] : max; 
		}
	}

	private static void print() {
		System.out.println(N - max);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
