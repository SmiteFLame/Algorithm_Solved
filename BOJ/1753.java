package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1753_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int V, E, start;
	static int[] distance;
	static LinkedList<int[]>[] adjList;
	static PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	});

	private static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new LinkedList[V + 1];
		distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		
		start = Integer.parseInt(in.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
	}

	private static void implement() {
		distance[start] = 0;
		pQueue.offer(new int[] {0, start});
		while(!pQueue.isEmpty()) {
			int[] now = pQueue.poll();
			for(int[] next : adjList[now[1]]) {
				if(distance[next[0]] > now[0] + next[1]) {
					distance[next[0]] = now[0] + next[1];
					pQueue.offer(new int[] {distance[next[0]], next[0]});
				}
			}
		}
	}

	private static void print() throws IOException{
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) ot.write("INF\n");
			else ot.write(distance[i] + "\n");
		}
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
