package ssafy.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1327 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, answer;
	static List<Integer> data = new ArrayList<>();
	
	static Set<List<Integer>> set = new HashSet<>();
	
	static Queue<Node> queue = new LinkedList<>();
	
	static class Node{
		int cnt;
		List<Integer> arr;
		
		public Node(int cnt, List<Integer> arr) {
			this.cnt = cnt;
			this.arr = arr;
		}		
	}


	private static List<Integer> change(int start, List<Integer> arr) {
		List<Integer> list = new ArrayList<>(arr);
		for(int i = 0, end = K / 2; i < end; i++) {
			int temp = list.get(start + i);
			list.set(start + i, list.get(start + K - i - 1));
			list.set(start + K - i - 1, temp);
		}
		
		return list;
	}
	private static boolean check(List<Integer> arr) {
		for(int i = 0, end = arr.size() - 1; i < end; i++) {
			if(arr.get(i) < arr.get(i + 1)) continue;
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			data.add(Integer.parseInt(st.nextToken()));
		}
		
		queue.add(new Node(0, data));
		set.add(data);
		
		answer = -1;
		
	
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(check(now.arr)) {
				answer = now.cnt;
				break;
			}
			
			for(int i = 0; i <= N - K; i++) {
				List<Integer> list = change(i, now.arr);
				
				if(set.contains(list)) continue;
				set.add(list);
				queue.add(new Node(now.cnt + 1, list));
			}
		}

		System.out.println(answer);
	}

}
