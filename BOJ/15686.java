package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G5_15686_¾çµ¿Çõ {
	static int N, M, T, sizeH, sizeC, min;
	static LinkedList<int[]> home = new LinkedList<>();
	static LinkedList<int[]> chicken = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < N; j++) {
				T = Integer.parseInt(st.nextToken());
				if (T == 1)
					home.offer(new int[] { i, j });
				else if (T == 2)
					chicken.offer(new int[] { i, j });
			}
		}
		sizeH = home.size();
		sizeC = chicken.size();
		
		min = Integer.MAX_VALUE;
	}

	private static int dist(int homeIdx, int chickenIdx) {
		return Math.abs(home.get(homeIdx)[0] - chicken.get(chickenIdx)[0])
				+ Math.abs(home.get(homeIdx)[1] - chicken.get(chickenIdx)[1]);
	}

	private static void implement(int idx, int cnt, int flag) {
		if (idx == M) {
			int sumDist = 0;
			
			for (int i = 0; i < sizeH; i++) {
				int minDist = Integer.MAX_VALUE;
				
				for (int j = 0; j < sizeC; j++) {
					if ((flag & 1 << j) != 0) {
						T = dist(i, j);
						minDist = minDist < T ? minDist : T;
					}
				}
				sumDist += minDist;
			}
			min = min < sumDist ? min : sumDist;
			return;
		}

		if (cnt == sizeC)
			return;

		implement(idx + 1, cnt + 1, flag | 1 << cnt);
		implement(idx, cnt + 1, flag);
	}
	
	private static void print() {
		System.out.println(min);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement(0, 0, 0);
		print();
	}

}
