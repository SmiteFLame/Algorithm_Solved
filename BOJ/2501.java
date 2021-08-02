import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2501 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				cnt++;
				if(cnt == M) {
					System.out.println(i);
					return;
				}
			}
		}
		System.out.println(0);
	}

}
