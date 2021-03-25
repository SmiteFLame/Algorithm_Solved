package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, size;
	static int[] dp;
	static int[] LIS;

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		dp = new int[N];
		LIS = new int[N];
		size = 0;
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void implement() {
		LIS[size++] = dp[0];
		for (int i = 1; i < N; i++) {
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, dp[i])) - 1;
			LIS[temp] = dp[i];

			if(temp == size) {
				size++;
			}
		}
	}

	private static void print(int tc) throws IOException {
		ot.write("#" + tc + " " + size + "\n");
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			init();
			implement();
			print(tc);
		}
		ot.flush();
		ot.close();
	}

}
