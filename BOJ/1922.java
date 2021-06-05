import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[] parents;
	static PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[2], o2[2]);
		}

	});

	private static boolean union(int X, int Y) {
		int parX = find(X);
		int parY = find(Y);
		
		if (parX == parY)
			return false;
		parents[parX] = parY;
		
		return true;
	}

	private static int find(int X) {
		if (parents[X] == X)
			return X;
		return parents[X] = find(parents[X]);
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			pQueue.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) });
		}
		
		int cnt = 0, answer = 0;
		while(cnt < N - 1) {
			int[] now = pQueue.poll();
			if(union(now[0], now[1])) {
				cnt++;
				answer += now[2];
			}
		}

		System.out.println(answer);
	}
}