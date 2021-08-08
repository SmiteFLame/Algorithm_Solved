import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11728 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] left = new int[N];
		int[] right = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			left[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < M; i++) {
			right[i] = Integer.parseInt(st.nextToken());
		}
		int leftCnt = 0, rightCnt = 0;
		for(int i = 0; i < N + M; i++) {
			if(leftCnt == N) {
				ot.write(right[rightCnt++] + " ");
			} else if(rightCnt == M) {
				ot.write(left[leftCnt++] + " ");
			} else if(left[leftCnt] < right[rightCnt]) {
				ot.write(left[leftCnt++] + " ");
			} else {
				ot.write(right[rightCnt++] + " ");
			}
		}
		ot.flush();
		ot.close();
	}

}
