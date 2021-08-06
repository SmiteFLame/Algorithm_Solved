import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_20304 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int arr[] = new int[1000001];
		Arrays.fill(arr, Integer.MIN_VALUE);
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 1; i <= M; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[x] = 0;
			dq.offerLast(x);
		}
		
		while (!dq.isEmpty()) {
			int x = dq.pollFirst();
			for (int i = 0; i < 20; i++) {
				int nx = x ^ (1 << i);
				if (nx > N || arr[nx] != Integer.MIN_VALUE)
					continue;
				arr[nx] = arr[x] + 1;
				dq.offerLast(nx);
				answer = Math.max(answer, arr[nx]);
			}
		}
		
		System.out.println(answer);
	}
}
