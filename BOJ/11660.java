import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11660 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] sum = new int[N + 1][N + 1];
		int[][] data = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int next = 0;
			for (int j = 1; j <= N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i - 1][j] + next + data[i][j];
				next += data[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int fx = Integer.parseInt(st.nextToken()) - 1;
			int fy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int answer = sum[ex][ey] - sum[fx][ey] - sum[ex][fy] + sum[fx][fy];
			ot.write(answer + "\n");
		}
		ot.flush();
		ot.close();

	}

}
