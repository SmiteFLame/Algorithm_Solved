package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_17472_양동혁 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int N, M;
	static int[] parents;
	static int[][] map;
	static int[][] road;

	private static boolean canMove(int X, int Y) {
		if (X < 0 || Y < 0 || X >= N || Y >= M) {
			return false;
		}
		return true;
	}
	
	private static boolean union(int X, int Y) {
		int parX = find(X);
		int parY = find(Y);
		if(parX == parY) return false;
		parents[parX] = parY;
		return true;
	}
	
	private static int find(int X) {
		if(parents[X] == X) return X;
		return parents[X] = find(parents[X]);
	}

	public static void main(String[] args) throws IOException {
//		1. 데이터 입력;
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<LinkedList<int[]>> list = new ArrayList<>();

//		2. 섬의 위치 확인하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 1)
					continue;
				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] { i, j });
				LinkedList<int[]> temp = new LinkedList<>();
				map[i][j] = list.size() + 2;
				while (!queue.isEmpty()) {
					int[] now = queue.poll();
					temp.offer(new int[] { now[0], now[1] });
					
					for(int n = 0; n < 4; n++) {
						if(canMove(now[0] + NEWS[n][0], now[1] + NEWS[n][1])
								&& map[now[0] + NEWS[n][0]][now[1] + NEWS[n][1]] == 1) {

							map[now[0] + NEWS[n][0]][now[1] + NEWS[n][1]] = map[i][j];
							queue.offer(new int[] { now[0] + NEWS[n][0], now[1] + NEWS[n][1] });
						}
					}
				}

				list.add(temp);
				// 시작점, 끝점
			}
		}
		
		int end =  list.size();

		road = new int[end][end];
		for (int i = 0; i < end; i++) {
			Arrays.fill(road[i], Integer.MAX_VALUE);
		}

//		3. 각 섬마다 거리 확인하기
		for (int i = 0; i < end; i++) {
			for(int j = 0, endj = list.get(i).size(); j < endj; j++) {
				for(int n = 0; n < 4; n++) {
					int cnt = 0;
					int nx = list.get(i).get(j)[0];
					int ny = list.get(i).get(j)[1];
					while(true) {
						nx += NEWS[n][0];
						ny += NEWS[n][1];
						if(!canMove(nx, ny)) break;
						if(map[nx][ny] == i + 2) break;
						if(map[nx][ny] != 0) {
							if(cnt <= 1) break;
							road[i][map[nx][ny] - 2] = cnt < road[i][map[nx][ny] - 2] ? cnt : road[i][map[nx][ny] - 2];
							road[map[nx][ny] - 2][i] = cnt < road[map[nx][ny] - 2][i] ? cnt : road[map[nx][ny] - 2][i];
							break;
						}
						cnt++;
					}
				}
			}
		}

//		4. 크루스칼 알고리즘
		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
			
		});
		
		parents = new int[end];
		
		for (int i = 0; i < end; i++) {
			parents[i] = i;
			for(int j = i + 1; j < end; j++) {
				if(road[i][j] == Integer.MAX_VALUE) continue;
				pQueue.offer(new int[] {i, j, road[i][j]});
			}
		}
		
		int cnt = 0;
		int answer = 0;
		while(cnt < end - 1 && !pQueue.isEmpty()) {
			int[] now = pQueue.poll();
			if(union(now[0], now[1])) {
				cnt++;
				answer += now[2];
			}
		}
//		5. 값 출력하기
		System.out.println(cnt == end - 1 ? answer : -1);
	}
}
