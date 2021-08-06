import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2357 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static long[] data;
	static long[][] tree;

	private static void init(int now, int start, int end) {
		if (start == end) {
			tree[now][0] = data[start];
			tree[now][1] = data[start];
			return;
		}

		int mid = (start + end) / 2;
		init(now * 2, start, mid);
		init(now * 2 + 1, mid + 1, end);
		tree[now][0] = Math.min(tree[now * 2][0], tree[now * 2 + 1][0]);
		tree[now][1] = Math.max(tree[now * 2][1], tree[now * 2 + 1][1]);

	}

	private static long[] find(int now, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return new long[] { Long.MAX_VALUE, Long.MIN_VALUE };
		}

		if (left <= start && end <= right) {
			return tree[now];
		}

		int mid = (start + end) / 2;
		long[] first = find(now * 2, start, mid, left, right);
		long[] second = find(now * 2 + 1, mid + 1, end, left, right);
		return new long[] { Math.min(first[0], second[0]), Math.max(first[1], second[1]) };
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N + 1];
		tree = new long[N * 4][2];

		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(in.readLine());
		}

		init(1, 1, N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			long[] answer = find(1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			ot.write(answer[0] + " " + answer[1] + "\n");
		}
		ot.flush();
		ot.close();
	}

}
