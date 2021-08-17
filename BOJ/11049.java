import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11049 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		int[][] data = new int[N][2];
		int[][] DP = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(DP[i], Integer.MAX_VALUE);
			DP[i][i] = 0;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; i + j < N; j++) {
				for (int x = j; x < i + j; x++) {
					DP[j][i + j] = Math.min(DP[j][i + j],
							DP[j][x] + DP[x + 1][i + j] + data[j][0] * data[x][1] * data[i + j][1]);
				}
			}
		}
		System.out.println(DP[0][N - 1]);

	}

}
