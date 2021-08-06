import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10868 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static long[] data;
	static long[] tree;

	private static void init(int now, int start, int end) {
		if (start == end) {
			tree[now] = data[start];
			return;
		}

		int mid = (start + end) / 2;
		init(now * 2, start, mid);
		init(now * 2 + 1, mid + 1, end);
		tree[now] = Math.min(tree[now * 2], tree[now * 2 + 1]);

	}

	private static long find(int now, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return Long.MAX_VALUE;
		}

		if (left <= start && end <= right) {
			return tree[now];
		}

		int mid = (start + end) / 2;
		return  Math.min(find(now * 2, start, mid, left, right), find(now * 2 + 1, mid + 1, end, left, right));
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N + 1];
		tree = new long[N * 4];

		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(in.readLine());
		}

		init(1, 1, N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			long answer = find(1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			ot.write(answer + "\n");
		}
		ot.flush();
		ot.close();
	}

}
