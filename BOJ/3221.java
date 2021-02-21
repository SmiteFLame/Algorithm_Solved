package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3221 {
	static int L, T, N;
	static int[][] ant;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		L = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()) % (L * 2);

		N = Integer.parseInt(io.readLine());
		ant = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			ant[i][0] = Integer.parseInt(st.nextToken());
			ant[i][1] = st.nextToken().charAt(0) == 'L' ? -1 : 1;
		}
	}

	private static void implement() {
		for (int i = 0; i < N; i++) {
	        int p, q;
	        int t;
	        if (ant[i][1] == -1) {
	            t = T - ant[i][0];
	            if (t < 0)
	            	ant[i][0] -= T;
	            else {
	                p = t / L;
	                q = t % L;
	                ant[i][0] = (p & 1) != 0? L - q : q;
	            }
	        }

	        else {
	            t = T - (L - ant[i][0]);
	            if (t < 0)
	            	ant[i][0] += T;
	            else {
	                p = t / L;
	                q = t % L;
	                ant[i][0] = (p & 1) != 0 ? q : L - q;
	            }
	        }
		}

	}

	private static void print() {
		Arrays.sort(ant, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.print(ant[i][0] + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}
}
