package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solutuib_D4_3289_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[] parents;

	private static void init(int tc) throws IOException {
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		ot.write("#" + tc + " ");
	}

	private static void union(int a, int b) {
		int aHead = find(a);
		int bHead = find(b);
		parents[aHead] = bHead;		
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static void implement() throws IOException {
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			if (st.nextToken().charAt(0) == '0') {
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} else {
				if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))) {
					ot.write('1');
				} else {
					ot.write('0');
				}
			}
		}
		ot.write("\n");
	}

	private static void print() throws IOException {
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			init(tc);
			implement();
		}
		print();
	}

}
