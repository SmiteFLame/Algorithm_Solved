package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Msin_S1_2564_양동혁 {
	static int N, M, K, ans;
	static Location[] loc;
	static Location ply;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Location {
		int NEWS;
		int X;

		public Location(int nEWS, int x) {
			NEWS = nEWS;
			X = x;
		}

	}

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(io.readLine());

		loc = new Location[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(io.readLine());
			loc[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(io.readLine());
		ply = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}

//	북  - 1, 남 - 2, 서 - 3, 동 - 4
	private static void implement() {
		for (int i = 0; i < K; i++) {
//			서로 같이 있거나 건너편에 있을 경우
			if ((loc[i].NEWS - 1) / 2 == (ply.NEWS - 1) / 2) {
				if (loc[i].NEWS == ply.NEWS) {
					ans += Math.abs(loc[i].X - ply.X);
				} else {
					if (ply.NEWS <= 2) {
						ans += (Math.min(loc[i].X + ply.X, (2 * N) - (loc[i].X + ply.X)) + M);
					} else {
						ans += (Math.min(loc[i].X + ply.X, (2 * M) - (loc[i].X + ply.X)) + N);
					}
				}
//			옆에 있을 경우
			} else {
				if (loc[i].NEWS + ply.NEWS == 4) {
					ans += (loc[i].X + ply.X);
				} else if (loc[i].NEWS + ply.NEWS == 6) {
					ans += ((N + M) - (loc[i].X + ply.X));
				} else {
					if (ply.NEWS % 2 == 0) {
						ans += ply.X;
					} else if (ply.NEWS == 1) {
						ans += (N - ply.X);
					} else {
						ans += (M - ply.X);
					}

					if (loc[i].NEWS % 2 == 0) {
						ans += loc[i].X;
					} else if (loc[i].NEWS == 1) {
						ans += (N - loc[i].X);
					} else {
						ans += (M - loc[i].X);
					}
				}
			}
		}
	}

	private static void print() {
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
