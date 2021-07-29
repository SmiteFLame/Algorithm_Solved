import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6549 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[] arr, tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		while (true) {
			st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			tree = new int[N * 4];
			init(1, 1, N);

			ot.write(implement(1, N, N) + "\n");
		}
		ot.flush();
		ot.close();
	}

	public static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}
		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid + 1, end);

		tree[node] = arr[tree[node * 2]] <= arr[tree[node * 2 + 1]] ? tree[node * 2] : tree[node * 2 + 1];

	}

	public static int query(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return -1;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		int m1 = query(start, mid, node * 2, left, right);
		int m2 = query(mid + 1, end, node * 2 + 1, left, right);

		if (m1 == -1)
			return m2;
		else if (m2 == -1)
			return m1;
		else
			return arr[m1] <= arr[m2] ? m1 : m2;

	}

	public static long implement(int start, int end, int N) {
		int m = query(1, N, 1, start, end);

		long area = (end - start + 1) * (long) arr[m];

		if (start <= m - 1) {
			long tmp = implement(start, m - 1, N);

			area = Math.max(area, tmp);
		}

		if (m + 1 <= end) {
			long tmp = implement(m + 1, end, N);

			area = Math.max(area, tmp);
		}

		return area;
	}

}
