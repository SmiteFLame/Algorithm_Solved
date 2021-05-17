package ssafy.study.week13;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_13549 {

	static final int MAX = 100000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] data = new int[MAX + 1];
		Arrays.fill(data, Integer.MAX_VALUE);
		
//		PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(time[x], time[y]));
		PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		
		queue.offer(new int[] {N, 0});
		data[N] = 0;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == K) {
				System.out.println(now[1]);
				return;
			}
			
			if(now[0] * 2 >= 0 && now[0] * 2 <= MAX && data[now[0]] < data[now[0] * 2]) {
				data[now[0] * 2] = data[now[0]];
				queue.offer(new int[] {now[0] * 2, now[1]});				
			}
			if(now[0] + 1 >= 0 && now[0] + 1 <= MAX && data[now[0]] + 1 < data[now[0] + 1]) {
				data[now[0] + 1] = data[now[0]] + 1;
				queue.offer(new int[] {now[0] + 1, now[1] + 1});				
			}
			if(now[0] - 1 >= 0 && now[0] - 1 <= MAX && data[now[0]] + 1 < data[now[0] - 1]) {
				data[now[0] - 1] = data[now[0]] + 1;
				queue.offer(new int[] {now[0] - 1, now[1] + 1});				
			}
		}
	}

}
