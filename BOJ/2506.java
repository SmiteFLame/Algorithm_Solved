import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5532 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int sum = 0;
		int cnt = 1;
		for(int i = 0; i < N; i++) {
			if(st.nextToken().equals("1")) {
				sum += cnt;
				cnt++;
			} else {
				cnt = 1;
			}			
		}
		System.out.println(sum);
	}

}
