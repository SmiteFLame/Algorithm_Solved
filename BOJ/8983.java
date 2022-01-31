import java.io.*;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int M, N, L;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {

		String[] sarr = br.readLine().split(" ");
		M = Integer.parseInt(sarr[0]);
		N = Integer.parseInt(sarr[1]);
		L = Integer.parseInt(sarr[2]);

		arr = new int[M];

		sarr = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			int x = Integer.parseInt(sarr[0]);
			int y = Integer.parseInt(sarr[1]);

			int pos = binSearch(x, y, 0, M - 1);
			int dist = Math.abs(arr[pos] - x) + y;

			if (dist <= L)
				cnt++;
		}

		bw.write(cnt + " ");
		bw.flush();

	}

	public static int binSearch(int x, int y, int left, int right) {
		int pl = left;
		int pr = right;
		do {
			int pc = (pl + pr) / 2;
			int dist = Math.abs(arr[pc] - x) + y;
			if (dist <= L || arr[pc] == x)
				return pc;
			if (arr[pc] < x)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		if (pl > right)
			return pr;
		if (pr < left)
			return pl;
		return (Math.abs(arr[pl] - x) < Math.abs(arr[pr] - x) ? pl : pr);
	}
}