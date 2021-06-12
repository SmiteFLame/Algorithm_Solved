package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1446 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, D;
	
	static Map<Integer, LinkedList<Road>> map = new HashMap<>();

	static class Road {
		int End, Size;

		public Road(int end, int size) {
			End = end;
			Size = size;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int[] DP = new int[D + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			if(end > D) continue;
			
			map.putIfAbsent(start, new LinkedList<>());
			map.get(start).add(new Road(end, size));
		}
		
		for(int i = 1; i <= D; i++) {
			DP[i] = i;
		}
		
		for(int i = 0; i < D; i++) {
			DP[i + 1] = DP[i] + 1 < DP[i + 1] ? DP[i] + 1 : DP[i + 1];
			
			if(!map.containsKey(i)) continue;
			
			for(Road road : map.get(i)) {
				DP[road.End] = DP[i] + road.Size < DP[road.End] ? DP[i] + road.Size : DP[road.End];
			}		
		}
		
		System.out.println(DP[D]);
	}

}
