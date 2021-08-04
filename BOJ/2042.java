import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2042 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static long[] data, tree;

	public static long init(int begin, int end, int now) {
		if (begin == end) {
			return tree[now] = data[begin];
		}

		int middle = (begin + end) / 2;

		return tree[now] = init(begin, middle, now * 2) + init(middle + 1, end, now * 2 + 1);
	}

	public static long sum(int begin, int end, int now, int left, int right) {
		if (left > end || right < begin) {
			return 0;
		}

		if (left <= begin && end <= right) {
			return tree[now];
		}

		int middle = (begin + end) / 2;
		return sum(begin, middle, now * 2, left, right) + sum(middle + 1, end, now * 2 + 1, left, right);
	}

	public static void change(int begin, int end, int now, int idx, long level) {
		if (idx < begin || idx > end) {
			return;
		}

		tree[now] += level;
		if (begin == end) {
			return;
		}

		int middle = (begin + end) / 2;
		change(begin, middle, now * 2, idx, level);
		change(middle + 1, end, now * 2 + 1, idx, level);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		data = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(in.readLine());
		}
		tree = new long[N * 4];

		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());

			int order = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			long now = Long.parseLong(st.nextToken());

			if (order == 1) {
				long temp = now - data[loc];
				data[loc] = now;
				change(1, N, 1, loc, temp);
			} else if (order == 2) {
				ot.write(sum(1, N, 1, loc, (int) now) + "\n");
			}
		}

		ot.flush();
		ot.close();
	}

}