import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1547 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int answer = 1;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			if(X == answer) {
				answer = Y;
			} else if(Y == answer) {
				answer = X;
			}
		}
		System.out.println(answer);
	}

}
