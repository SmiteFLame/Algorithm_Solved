import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	static class Bus{
		int end;
		int cost;

		public Bus(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		List<Bus>[] bus = new ArrayList[N + 1];
		int[] dis = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			bus[i] = new ArrayList<>();
			dis[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			bus[Integer.parseInt(st.nextToken())]
					.add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Bus> pQueue = new PriorityQueue<>(new Comparator<Bus>() {
			@Override
			public int compare(Bus o1, Bus o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		pQueue.offer(new Bus(start, 0));
		dis[start] = 0;
		while(!pQueue.isEmpty()) {
			Bus now = pQueue.poll();
			if(dis[now.end] < now.cost) continue;
			
			for(Bus next : bus[now.end]) {
				if(dis[now.end] + next.cost < dis[next.end]) {
					dis[next.end] = dis[now.end] + next.cost;
					pQueue.offer(new Bus(next.end, dis[next.end]));
				}
			}
		}
		System.out.println(dis[end]);

	}
}
