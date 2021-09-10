import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_1738 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[] previous, ans;
	static Long[] costs;
	static ArrayList<Way>[] ways;
	static ArrayList<Way> cycle = new ArrayList<>();

	static class Way {
		int to, cost;

		public Way(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ways = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			ways[i] = new ArrayList<>();
		}
		previous = new int[N + 1];
		ans = new int[N + 1];
		costs = new Long[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			ways[u].add(new Way(v, -w));
		}
		for (int i = 1; i < N + 1; i++) {
			costs[i] = Long.MAX_VALUE;
		}

		costs[1] = 0L;
		for (int z = 1; z <= N + 1; z++) {
			for (int i = 1; i < N + 1; i++) {
				for (int k = 0; k < ways[i].size(); k++) {
					Way way = ways[i].get(k);
					int to = way.to;
					int cost = way.cost;

					if (costs[i] == Long.MAX_VALUE)
						continue;
					if (costs[i] == Long.MIN_VALUE)
						costs[to] = Long.MIN_VALUE;
					if (costs[to] > costs[i] + cost) {
						costs[to] = costs[i] + cost;
						previous[to] = i;
						if (z == N + 1) {

							costs[to] = Long.MIN_VALUE;
						}
					}
				}
			}
		}

		if (costs[N] == Long.MIN_VALUE || costs[N] == Long.MAX_VALUE)
			bw.write("-1");
		else {
			Stack<Integer> queue = new Stack<>();
			queue.add(N);
			while (true) {
				int peek = queue.peek();
				queue.add(previous[peek]);
				if (peek == 1)
					break;
			}
			while (!queue.isEmpty()) {
				int popValue = queue.pop();
				if (popValue != 0) {
					bw.write(popValue + " ");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
