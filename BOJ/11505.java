import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11505 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static final long DIV = 1000000007;

	static int N, M, K;
	static long[] data, tree;

	private static long init(int now, int start, int end) {
		if (start == end) {
			return tree[now] = data[start];
		}

		int mid = (start + end) / 2;
		return tree[now] = (init(now * 2, start, mid) * init(now * 2 + 1, mid + 1, end)) % DIV;
	}

	private static long change(int now, int start, int end, int level, long val) {
		if (level < start || end < level) {
			return tree[now];
		}

		if (start == end) {
			return tree[now] = val;
		}

		int mid = (start + end) / 2;
		return tree[now] = (change(now * 2, start, mid, level, val) * change(now * 2 + 1, mid + 1, end, level, val)) % DIV;
	}

	private static long product(int now, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 1;
		}

		if (left <= start && end <= right) {
			return tree[now];
		}

		int mid = (start + end) / 2;
		return (product(now * 2, start, mid, left, right) * product(now * 2 + 1, mid + 1, end, left, right)) % DIV;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new long[N + 1];
		tree = new long[N * 4];
		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(in.readLine());
		}
		init(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());
			int order = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			long Y = Long.parseLong(st.nextToken());
			if (order == 1) {
				change(1, 1, N, X, Y);
				data[X] = Y;
			} else {
				ot.write(product(1, 1, N, X, (int) Y) + "\n");
			}
		}
		ot.flush();
		ot.close();
	}

}
