import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] count = new int[N + 1];
		LinkedList<Integer>[] back = new LinkedList[N + 1];
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			back[i] = new LinkedList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int front = Integer.parseInt(st.nextToken());
			for(int j = 1; j < K; j++) {
				int next = Integer.parseInt(st.nextToken());
				back[front].add(next);
				count[next]++;
				front = next;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(count[i] != 0) continue;
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			bw.write(now + "\n");
			answer++;
			for(Integer next : back[now]) {
				count[next]--;
				if(count[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		if(answer == N) {
			bw.flush();
			bw.close();
		} else {
			System.out.println("0");
		}
	}
}
