import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MAX = 4000000;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] array = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			Arrays.fill(array[i], MAX);
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			array[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer
					.parseInt(st.nextToken());
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
				}
			}
		}

		int answer = MAX;
		for (int i = 1; i <= V; i++) {
			answer = Math.min(answer, array[i][i]);
		}
		System.out.println(answer == MAX ? -1 : answer);
	}

}
