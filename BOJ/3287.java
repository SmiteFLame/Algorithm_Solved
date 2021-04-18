package justonly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_3687 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));

	static final int[] minNumbers = { 0, 0, 1, 7, 4, 2, 0, 8, 10 };

	static int N;
	static long[] DP;
	public static void main(String[] args) throws IOException {
		DP = new long[101];
		
		for(int i = 0; i < 9; i++) {
			DP[i] = minNumbers[i];
		}
		DP[6] = 6;
		
		for(int i = 9; i <= 100; i++) {
			DP[i] = DP[i - 2] * 10 + minNumbers[2];
			for(int j = 3; j < 8; j++) {
				DP[i] = Math.min(DP[i], DP[i - j] * 10 +  minNumbers[j]);
			}
		}
		
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			N = Integer.parseInt(in.readLine());

			ot.write(Long.toString(DP[N]));
			
			ot.write(" ");
			// ÃÖ´ë

			ot.write(N % 2 == 1 ? "7" : "1");
			for (int i = 0, endi = N / 2; i < endi - 1; i++) {
				ot.write("1");
			}
			ot.write("\n");
		}
		ot.flush();
		ot.close();

	}

}
