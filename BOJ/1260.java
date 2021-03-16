package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_¾çµ¿Çõ {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, V;
	static LinkedList<Integer>[] data;
	static boolean[] visited;
	
	private static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		data = new LinkedList[N + 1];
		
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			data[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			data[from].addLast(to);
			data[to].addLast(from);
		}
		
		for(int i = 1; i <= N; i++) {
			data[i].sort(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}				
			});
		}
		
	}
	
	private static void DFS(int cur) throws IOException{
		ot.write(cur + " ");
		visited[cur] = true;
		for(Integer temp : data[cur]) {
			if(visited[temp]) continue;
			DFS(temp);
		}
	}
	
	private static void BFS(int cur)  throws IOException{
		visited = new boolean[N + 1];
		visited[cur] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		while(!queue.isEmpty()) {
			cur = queue.poll();
			ot.write(cur + " ");
			for(Integer temp : data[cur]) {
				if(visited[temp]) continue;
				visited[temp] = true;
				queue.offer(temp);
			}
		}
	}
	
	private static void implement()  throws IOException{
		DFS(V);
		ot.write("\n");
		BFS(V);
	}
	
	private static void print() throws IOException{
		ot.flush();
		ot.close();
	}
	
	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();		
	}
}
