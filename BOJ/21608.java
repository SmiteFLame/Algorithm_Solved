package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21608 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	static class student implements Comparable<student> {
		int fcnt;
		int cnt;
		int X, Y;

		public student(int fcnt, int cnt, int x, int y) {
			this.fcnt = fcnt;
			this.cnt = cnt;
			X = x;
			Y = y;
		}

		@Override
		public int compareTo(student o) {
			if (this.fcnt != o.fcnt)
				return Integer.compare(o.fcnt, this.fcnt);
			if (this.cnt != o.cnt)
				return Integer.compare(o.cnt, this.cnt);
			if (this.X != o.X)
				return Integer.compare(this.X, o.X);
			return Integer.compare(this.Y, o.Y);
		}

	}

	private static boolean canMove(int X, int Y, int N) {
		return !(X < 0 || Y < 0 || X >= N || Y >= N);
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		int max = N * N;
		int[][] table = new int[N][N];

		ArrayList<Integer>[] friendlist = new ArrayList[max + 1];
		for (int t = 0; t < max; t++) {
			st = new StringTokenizer(in.readLine());
			ArrayList<Integer> friend = new ArrayList<>();
			int now = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				friend.add(Integer.parseInt(st.nextToken()));
			}

			friendlist[now] = friend;

			PriorityQueue<student> pQueue = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int fcnt = 0;
					int cnt = 0;

					if (table[i][j] != 0)
						continue;

					for (int d = 0; d < 4; d++) {
						int nx = i + NEWS[d][0];
						int ny = j + NEWS[d][1];
						if (!canMove(nx, ny, N))
							continue;
						if (table[nx][ny] == 0)
							cnt++;
						else if (friend.contains(table[nx][ny]))
							fcnt++;
					}
					pQueue.add(new student(fcnt, cnt, i, j));
				}
			}
			
			student sit = pQueue.poll();
			
			table[sit.X][sit.Y] = now;
		}
		
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int now = table[i][j];
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nx = i + NEWS[d][0];
					int ny = j + NEWS[d][1];
					if(!canMove(nx, ny, N)) continue;
					
					if(friendlist[now].contains(table[nx][ny])) cnt++;
				}
				
				if(cnt == 1) {
					answer ++;
				}
				if(cnt == 2) {
					answer += 10;
				}
				if(cnt == 3) {
					answer += 100;
				}
				if(cnt == 4) {
					answer += 1000;
				}
			}
		}
		
		System.out.println(answer);
	}

}
