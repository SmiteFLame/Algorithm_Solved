package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int V, E;
	static int[] parent;
	static PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[2], o2[2]);
		}
	});
	
	private static boolean union(int X, int Y) {
		int pX = find(X);
		int pY = find(Y);
		if(pX == pY) return false;
		parent[pX] = pY;
		return true;
	}
	
	private static int find(int X) {
		if(X == parent[X]) return X;
		return parent[X] = find(parent[X]);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			pQueue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) });
		}
		
		int cnt = 0;
		int answer = 0;
		while(cnt < V - 1 && !pQueue.isEmpty()) {
			int[] now = pQueue.poll();
			if(union(now[0], now[1])) {
				cnt++;
				answer += now[2];
			}
		}
		
		System.out.println(answer);
	}
}
