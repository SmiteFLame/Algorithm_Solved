package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main_11004 {

	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(io.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(io.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pQ.offer(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < K - 1; i++) {
			pQ.poll();
		}

		System.out.println(pQ.poll());
	}

}
