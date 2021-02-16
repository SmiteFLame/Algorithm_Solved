import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	static int[] root;
	static boolean check = true;
	static boolean[][] map;
	static Queue<Integer> queue = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		M = Integer.parseInt(io.readLine());
		map = new boolean[N][N];
		root = new int[N];

		Arrays.fill(root, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
	}

	private static void implement() throws IOException {
//		갈 수 있는 모든 도시들을 확인 한다.
		for (int i = 0; i < N; i++) {
			if (root[i] != Integer.MAX_VALUE)
				continue;
			root[i] = i;
			queue.offer(i);
			while (!queue.isEmpty()) {
				X = queue.poll();
				for (int j = 0; j < N; j++) {
					if (root[j] != Integer.MAX_VALUE)
						continue;
					if (map[X][j]) {
						root[j] = i;
						queue.offer(j);
					}
				}
			}
		}

		st = new StringTokenizer(io.readLine());
		int firstroot = root[Integer.parseInt(st.nextToken()) - 1];
		for (int i = 1; i < M; i++) {
			if (firstroot == root[Integer.parseInt(st.nextToken()) - 1])
				continue;
			check = false;
			break;
		}

	}

	private static void print() {
		System.out.println(check ? "YES" : "NO");
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();

	}

}
