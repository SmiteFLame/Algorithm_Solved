import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5676 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, K;
	static int[] data, tree;

	public static int init(int now, int start, int end) {
		if (start == end)
			return tree[now] = data[start];

		int mid = (start + end) / 2;

		return tree[now] = init(now * 2, start, mid) * init(now * 2 + 1, mid + 1, end);
	}

	public static void update(int now, int start, int end, int idx, int change) {
		if (start > idx || end < idx)
			return;

		if (start == end) {
			tree[now] = change;
			return;
		}
		if (start != end) {
			int mid = (start + end) / 2;
			update(now * 2, start, mid, idx, change);
			update(now * 2 + 1, mid + 1, end, idx, change);
			tree[now] = tree[2 * now] * tree[2 * now + 1];
		}
	}

	public static long multiple(int now, int start, int end, int left, int right) {
		if (left > end || right < start)
			return 1;

		if (left <= start && end <= right)
			return tree[now];

		int mid = (start + end) / 2;
		return multiple(now * 2, start, mid, left, right) * multiple(now * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws Exception {
		String temp;
		while ((temp = in.readLine()) != null) {
			st = new StringTokenizer(temp);
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			data = new int[N + 1];
			tree = new int[N * 4];
			st = new StringTokenizer(in.readLine());
			
			for (int i = 1; i <= N; i++) {
				int x = Integer.parseInt(st.nextToken());
				data[i] = x > 0 ? 1 : (x < 0 ? -1 : 0);
			}
			
			init(1, 1, N);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				String order = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (order.equals("C")) {
					if (b > 0)
						b = 1;
					else if (b < 0)
						b = -1;
					update(1, 1, N, a, b);
				} else { // delete
					long answer = multiple(1, 1, N, a, b);
					ot.write(answer > 0 ? "+" : (answer < 0 ? "-" : "0"));
				}
			}
			ot.write("\n");
		}
		ot.close();
	}
}
