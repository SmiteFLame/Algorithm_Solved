import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1965 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int[] array = new int[N + 1];
		int[] DP = new int[N + 1];
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(DP, 1);
		for (int i = 1; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				if(array[j] < array[i] && DP[i] < DP[j] + 1) {
					DP[i] = DP[j] + 1;
				}
			}
			answer = answer > DP[i] ? answer : DP[i];
		}
		System.out.println(answer);

	}

}
