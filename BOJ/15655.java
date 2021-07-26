import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M;
	static int[] data;
	static int[] answer;
	private static void subset(int idx, int cnt) throws IOException {
		
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				ot.write(answer[i] + " ");
			}
			ot.write("\n");
			return;
		}

		if(idx == N) {
			return;
		}
		answer[cnt] = data[idx];
		subset(idx + 1, cnt + 1);
		subset(idx + 1, cnt);
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
