import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, max;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		max = -1;
		data = new int[N];
		st = new StringTokenizer(io.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void per(int cnt,int idx, int sum) {
		if(cnt == 2) {
			max = sum > max ? sum : max;
			return;
		}
		for(int i = idx; i < N; i++) {
			if(sum + data[i] <= M) per(cnt + 1, i + 1, sum + data[i]);
		}
	}
	
	private static void print(int test_case) {
		sb.append("#").append(test_case).append(" ").append(max).append("\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(io.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			per(0, 0, 0);
			print(test_case);
		}

		System.out.println(sb.toString());
	}
}