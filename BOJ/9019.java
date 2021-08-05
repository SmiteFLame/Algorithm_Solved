import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Register{
		int num;
		String answer;
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String[] data = new String[10000];
			int input = Integer.parseInt(st.nextToken());
			int want = Integer.parseInt(st.nextToken());
			data[input] = "A";
			Queue<Integer> queue = new LinkedList<>();
			queue.add(input);
			while(!queue.isEmpty()) {
				int now = queue.poll();
				
				if(now == want) {
					break;
				}
				
				int D = (now * 2) % 10000;
				if(data[D] == null) {
					data[D] = data[now] + "D";
					queue.add(D);
				}
				
				int S = now == 0 ? 9999 : now - 1;
				if(data[S] == null) {
					data[S] = data[now] + "S";
					queue.add(S);
				}
				
				int L = (now - (now / 1000) * 1000) * 10 + now / 1000;
				if(data[L] == null) {
					data[L] = data[now] + "L";
					queue.add(L);
				}
				
				int R = (now + ((now % 10) * 10000)) / 10;
				if(data[R] == null) {
					data[R] = data[now] + "R";
					queue.add(R);
				}
			}
			ot.write(data[want].substring(1) + "\n");
		}
		ot.flush();
		ot.close();
	}
}
