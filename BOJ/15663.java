import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15663 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M;
	static int[] data;
	static int[] answer;
	static Set<String> set = new HashSet<>();
	private static void subset(int idx, int flag) throws IOException{
		if(idx == M) {
			String now = Arrays.toString(answer);
			if(set.contains(now)) return;
			set.add(now);
			for(int next : answer) {
				ot.write(next + " ");
			}
			ot.write("\n");
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			answer[idx] = data[i];
			subset(idx + 1, flag | 1 << i);
		}
	}

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		answer = new int[M];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		subset(0, 0);
		ot.flush();
		ot.close();
		
	}
}
