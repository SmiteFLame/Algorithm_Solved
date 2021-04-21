package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16235 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
			{ 0, -1 } };

	static int N, M, K;
	static int[][] S2D2;
	static int[][] soil;

	static PriorityQueue<tree> pQueue = new PriorityQueue<>();

	static class tree implements Comparable<tree> {
		int X, Y, age;

		public tree(int x, int y, int age) {
			X = x;
			Y = y;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			return Integer.compare(this.age, o.age);
		}

	}

	private static boolean canMove(int nx, int ny) {
		return !(nx < 0 || ny < 0 || nx >= N || ny >= N);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		S2D2 = new int[N][N];
		soil = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				S2D2[i][j] = Integer.parseInt(st.nextToken());
				soil[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			pQueue.add(new tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}

		for (int i = 0; i < K; i++) {
			ArrayList<tree> next = new ArrayList<>();
			ArrayList<tree> die = new ArrayList<>();

			// 봄 - 영양분을 먹음
			while (!pQueue.isEmpty()) {
				tree now = pQueue.poll();
				if (soil[now.X][now.Y] >= now.age) {
					soil[now.X][now.Y] -= now.age;
					now.age++;
					next.add(now);
				} else {
					die.add(now);
				}
			}

			// 여름 - 죽은 나무가 양분으로 추가( / 2)값
			for (int j = 0, end = die.size(); j < end; j++) {
				soil[die.get(j).X][die.get(j).Y] += (die.get(j).age) / 2;
			}

			// 가을 - 번식(5의 배수만, 인접 8칸에 나무 1이 생긴다)
			for (int j = 0, end = next.size(); j < end; j++) {
				if (next.get(j).age % 5 == 0) {
					for (int x = 0; x < 8; x++) {
						int nx = next.get(j).X + NEWS[x][0];
						int ny = next.get(j).Y + NEWS[x][1];
						if (!canMove(nx, ny))
							continue;
						next.add(new tree(nx, ny, 1));
					}
				}
			}
			
			// 겨울 - 양분 추가
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					soil[x][y] += S2D2[x][y];
				}
			}
			
			// 다시 우선 순위에 추가
			for (int j = 0, end = next.size(); j < end; j++) {
				pQueue.add(next.get(j));
			}
		}
		
		System.out.println(pQueue.size());
	}

}
