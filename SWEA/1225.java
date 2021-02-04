package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_¾çµ¿Çõ {
	static int deleteRange = 0, N;
	static StringTokenizer st = null;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static Queue<Integer> queue = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		for (int test_case = 1; test_case <= 10; test_case++) {
			deleteRange = 1;

			queue.clear();

			N = Integer.parseInt(io.readLine());

			st = new StringTokenizer(io.readLine());

			while (st.hasMoreTokens()) {
				queue.add(Integer.parseInt(st.nextToken()));
			}

			while (true) {

				int X = queue.poll() - deleteRange;
				if (X <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(X);
				}

				deleteRange = deleteRange == 5 ? 1 : deleteRange + 1;
			}

			sb.append("#" + test_case);
			for (int i : queue) {
				sb.append(" " + i);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
