import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_9466 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n;
	static int[] want;
	static int answer = 0;
	static boolean[] check;
	static boolean[] end;

	static void DFS(int now) {
		if (check[now])
			return;

		check[now] = true;
		int next = want[now];

		if (check[next] != true)
			DFS(next);
		else {
			if (end[next] != true) {
				answer++;
				for (int i = next; i != now; i = want[i])
					answer++;
			}
		}

		end[now] = true;
	}

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(in.readLine());
			want = new int[n + 1];
			check = new boolean[n + 1];
			end = new boolean[n + 1];
			answer = 0;

			st = new StringTokenizer(in.readLine());
			for (int i = 1; i < n + 1; i++)
				want[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i < n + 1; i++)
				DFS(i);

			ot.write((n - answer) + "\n");
		}
		ot.flush();
		ot.close();
	}
}